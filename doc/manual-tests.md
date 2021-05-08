# Manual tests documentation

## __A munka leírása__

A manuális tesztek célja az, hogy olyan eseteket teszteljen, olyan hibákat keressünk velük, amiket az automata tesztek nem tudnak ellenőrizni.

Mivel az egyes funkciók működőképességét a JUnit tesztek kiválóan tudják ellenőrizni, ezért ha ezek megfelelően futnak, akkor a modell működés szempontjából elfogadhatónak tekinthető.

A manuális tesztek során ezért elsősorban nem a modell, hanem a `view`, vagyis a felület működőképességéről szeretnénk megbizonyosodni. Részletesebben, arra vagyunk kiváncsiak, hogy a felület automatikusan frissül-e a periodikus események hatására, vagyis azon eseményekre, amiket maga a modell generál, illetve ugyanez a frissítés megtörténik-e, ha a felületen végzett akciók hatására változik a modell.

Továbbá itt teszteljük azon funkciókat is, amik egységtesztekkel nem feltétlenül megvalósíthatóak, ideértve a játékállapot kimentését és visszatöltését.


## __A feladat eredményeként elkészített tesztek__

Ha ezen tesztek közül mindegyik sikeres, akkor a grafikus felület működése elfogadhatónak tekinthető.

| Teszt neve        | Teszt típusa           |
| :------------- |:-------------|
| Pálya inicializáció ellenőrzése     | külső akció hatására bekövetkezett esemény |
| Játékosok és körök váltakozása        | belső, automatikus esemény    |
| A játék mentése | külső akció hatására a modell egy funkcióját teszteli     |
| A játék visszatöltése| külső akció hatására a modell egy funkcióját teszteli     |
| Játékosok mozgásának megjelenítése | külső akció hatására bekövetkezett esemény     |
| Jegesmedvék mozgása | belső, automatikus esemény     |
| Találkozás egy jegesmedvével | külső/belső akció hatására bekövetkezett esemény     |
| Ásás | külső akció hatására bekövetkezett esemény     |
| Eszközök kiásása | külső akció hatására bekövetkezett esemény     |
| Eszközök felvétele | külső akció hatására bekövetkezett esemény     |
| Eszközök használata | külső akció hatására bekövetkezett esemény     |
| Eszköz lerakása | külső akció hatására bekövetkezett esemény     |


## __Konklúzió__

A feladat talán legnagyobb tanulsága, hogy a kézi tesztek sohasem elhanyagolhatóak, mivel egy valóságos felhasználó bizonyos esetekben, főleg grafikus teszteknél, könnyebben kiszúr bizonyos problémákat, mint egy automatizált teszt. Ez főleg a prgramozók és a felhasználók esetlegeses eltérő gondolkodása miatt lehetséges.

_Természetesen az automatizált tesztek sem elhanyagolhatóak, ezen manuális tesztek csak kiegészítik őket._