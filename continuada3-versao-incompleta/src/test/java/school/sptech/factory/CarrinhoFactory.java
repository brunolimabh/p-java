package school.sptech.factory;

import school.sptech.Carrinho;
import school.sptech.utils.CarrinhoUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CarrinhoFactory {

    public static Object getInstance() throws ReflectiveOperationException {

        Class<Carrinho> carrinhoClazz = Carrinho.class;
        Constructor<?> constructor = carrinhoClazz.getConstructors()[0];

        Object[] args = new Object[constructor.getParameterCount()];
        Object carrinho = constructor.newInstance(args);

        Field campoProdutos = carrinhoClazz.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);

        campoProdutos.setAccessible(true);

        campoProdutos.set(carrinho, new ArrayList<>());

        return carrinho;
    }
}
