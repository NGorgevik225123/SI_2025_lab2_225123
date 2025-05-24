# SI_2025_lab2_225123
**Немања Ѓорѓевиќ, бр. на индекс 225123**

**Control Flow Graph:**
![Screenshot_1](https://github.com/user-attachments/assets/05683764-acd6-44a8-b8ce-abf09ba35c77)

**Цикломатска комплексност**
Цикломатската комплексност на овој код изнесува 9. Преку формулата P+1 го добив овој резултат, бидејќи бројот на услови во кодот изнесува 8. Следува 8+1 = 9.

**Тест случаи според критериумот Every Statement**
Тест случаи за функцијата checkCart според Every Statement критериум

1. Тест случај: allItems == null
   - Влез: allItems = null, валиден cardNumber
   - Резултат: Фрла RuntimeException "allItems list can't be null!"
   - Објаснување: Го покрива првиот услов и фрла исклучок.

2. Тест случај: item.getName() == null или празен String
   - Влез: Листа со Item каде еден има name null или празен
   - Резултат: Фрла RuntimeException "Invalid item!"
   - Објаснување: Проверка за валидност на име на артикл.

3. Тест случај: item.getPrice() > 300 или item.getDiscount() > 0 или item.getQuantity() > 10 е true
   - Влез: Item со цена > 300 или со попуст или количина > 10
   - Резултат: sum се намалува за 30
   - Објаснување: Покрива гранка каде се одзема 30 од сумата.

4. Тест случај: item.getDiscount() > 0 е true
   - Влез: Item со попуст > 0
   - Резултат: sum се зголемува со discounted price * quantity
   - Објаснување: Покрива гранка со попуст.

5. Тест случај: item.getDiscount() == 0 (else гранка)
   - Влез: Item без попуст
   - Резултат: sum се зголемува со price * quantity
   - Објаснување: Покрива гранка без попуст.

6. Тест случај: cardNumber == null или cardNumber.length() != 16
   - Влез: валидна листа, но cardNumber е null или со неправилна должина
   - Резултат: Фрла RuntimeException "Invalid card number!"
   - Објаснување: Покрива невалиден број на картичка.

7. Тест случај: cardNumber содржи невалиден карактер
   - Влез: валидна листа и cardNumber од 16 карактери кој не е број.
   - Резултат: Фрла RuntimeException "Invalid character in card number!"
   - Објаснување: Покрива проверка на валидност на карактери во бројот на картичката.

8. Тест случај: Сите проверки поминати успешно
   - Влез: валидна листа и валиден cardNumber од 16 цифри
   - Резултат: Враќа точна сума без исклучоци

Минимален број тест случаи за постигнување Every Statement критериум: 8

**Тест случаи според критериумот Multiple Condition за условот: if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)**
1. Тест случај 1:
   - price <= 300 (False)
   - discount = 0 (False)
   - quantity <= 10 (False)
   - Резултат: False
   - Објаснување: Ниту еден услов не е исполнет.

2. Тест случај 2:
   - price <= 300 (False)
   - discount = 0 (False)
   - quantity > 10 (True)
   - Резултат: True
   - Објаснување: Само quantity е поголем од 10.

3. Тест случај 3:
   - price <= 300 (False)
   - discount > 0 (True)
   - quantity <= 10 (False)
   - Резултат: True
   - Објаснување: Само discount е поголем од 0.

4. Тест случај 4:
   - price <= 300 (False)
   - discount > 0 (True)
   - quantity > 10 (True)
   - Резултат: True
   - Објаснување: discount и quantity се поголеми од дозволената големина.

5. Тест случај 5:
   - price > 300 (True)
   - discount = 0 (False)
   - quantity <= 10 (False)
   - Резултат: True
   - Објаснување: Само price е поголем од 300.

6. Тест случај 6:
   - price > 300 (True)
   - discount = 0 (False)
   - quantity > 10 (True)
   - Резултат: True
   - Објаснување: price и quantity се поголеми од дозволената големина.

7. Тест случај 7:
   - price > 300 (True)
   - discount > 0 (True)
   - quantity <= 10 (False)
   - Резултат: True
   - Објаснување: price и discount се поголеми од дозволената големина.

8. Тест случај 8:
   - price > 300 (True)
   - discount > 0 (True)
   - quantity > 10 (True)
   - Резултат: True
   - Објаснување: Сите три услови се поголеми од дозволената големина.

Минимален број на тест случаи за постигнување Multiple Condition критериум: 8
