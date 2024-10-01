import json
import re

def lambda_handler(event, context):
    print(f"event: {event}")
    cpf = event['cpf']

    resultado = valida_cpf(cpf)

    if (resultado['valido']):
        return {
            'status': 200,
            'parametros': event,
            'valido': True,
            'resultado': 'CPF válido :)'
        }
    else:
        return {
            'status': 400,
            'parametros': event,
            'valido': False,
            'resultado': resultado['erro']
        }


def valida_cpf(cpf):
  # Removendo os caracteres não numéricos
  cpf = ''.join(filter(str.isdigit, cpf))

    # Verificando se o CPF possui 11 dígitos
  if len(cpf) != 11:
    return {
      'erro': 'Não contém 11 dígitos',
      'valido': False
    }

  # Verificando se todos os dígitos são iguais
  if all(digit == cpf[0] for digit in cpf):
    return {
      'erro': 'Todos os dígitos são iguais',
      'valido': False
    }

  # Calculando o primeiro dígito verificador
  soma = 0
  for i, digito in enumerate(cpf[:9]):
    soma += int(digito) * (10 - i)
  resto = soma % 11
  digito1 = 0 if resto < 2 else 11 - resto

  # Calculando o segundo dígito verificador
  soma = 0
  for i, digito in enumerate(cpf[:10]):
    soma += int(digito) * (11 - i)
  resto = soma % 11
  digito2 = 0 if resto < 2 else 11 - resto

  # Verificando se os dígitos verificadores calculados são iguais aos dígitos verificadores do CPF
  valido = digito1 == int(cpf[9]) and digito2 == int(cpf[10])

  if (valido):
    return {
      'valido': True
    }

  return {
      'erro': "Dígito verificador inválido",
      'valido': False
    }