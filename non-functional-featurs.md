# Nem-funkcionális tesztek

## A játék felület használhatósága

### Játék felhasználói felülete
- Ha a játékot lerakjuk, a tálcára vagy át az ablakot át mozgatjuk egy másik monitorra akkor a játék eltűnik és csak egy kattintás után lehet használni.
![](pics/p1.png)
-  A játék ablakot nem lehet nem méretezhető ezért túl kicsi vagy túl nagy felbontásnál kényelmetlen a játék használata.

- Nincs lehetőség a régi mentések törlésére és nincs figyelmeztetés, amikor egy régi mentést írunk felűl.
- Nincs vizuális visszajelzés, amikor egy gombot lenyomunk
- A fő menüben a Resume és Save gomb megjeleni a játék kezdetekor, de semmi funkcionális jelentősége nincs, mivel nem lehet őket használni.
![](pics/p3.png)
- Lehetséges a mentéseket más típusú fájl ként is elmenteni de ezek nem lehet látni azonnal a Load gomb lenyomásával csak ha a fájl keresőben a kereset fájl típust átállítjuk all-ra.
- A játék nem tartalmaz az automatikus mentés, ezért ha a játékmentés nélkül bezárunk, vagy a játék összeomlik, akkor a játék menetünk teljesen elveszik.
## Stresszteszt

## Teljesítménytesztek

A teljesítmény tesztet a Junit Benchmark segítségével lett tesztelve. A teszt létrehoz egy GameManager objektumot és annak a ViewManager-rén meghívjuk a Update függvényt. A Benchmark a tesztet 20-szor futta le a tesztek.

![](pics/p2.png)
Itt látható a teszt eredménye

Látható az eredményből hogy egy kör átlagosan 0.28 sec alatt futott le és a teszt futása során 70 alkalommal lett meghívva a Garbage Collector. A teszt teljes futási 5.59 sec volt és ebből 0.01 sec a warmup és a bench 5.58 sec-ig futott.