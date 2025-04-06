package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {
    @Test
    void beanValidation(){
        //검증기 생성 (나중에 스프링이랑 통합 하면서 이런 코드는 작성하지 않기 때문에 이렇게 사용하는구나 정도로 알면 됨)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);

        //violations에 오류가 담김, 비었으면 오류가 없는것
        Set<ConstraintViolation<Item>> violatioins = validator.validate(item);
        for (ConstraintViolation<Item> violatioin : violatioins) {
            System.out.println("violatioin = " + violatioin);
            System.out.println("violatioin.getMessage() = " + violatioin.getMessage());
        }
    }
}
