package hiber.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
//во всех по дефолту  будет  рид онли, в нужных изменить в ручную на false
public class CarServiceImp implements CarService{

          /*мы не можем напрямую вызывать из репы
      - мы должны вызывать внутри хибер транзакции, транзакциями в том числе занимается сервис
       */

}
