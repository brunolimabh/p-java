package sptech.api_arquivos;

import java.util.Map;

public record RespostaCpf(
		int status,
		Map<String, Object> parametros,
		boolean valido,
		String resultado
) {
}
