# Stressz tesztek

3 különböző típusú stressztesztet végeztünk el:
- Medvék számának növelése
- Játékosok számának növelése
- Tárgyak számának növelése

A tesztekkel a játék elindulásának és betöltésének idejét mértük. Referenciaként egy olyan teszt szolgál, ami a játék elindulási idejét alapbeállítások mellett méri.

Mindegyik tesztet külön futtattuk egy azonos, **5x7** méretű (vagyis **35** mezőből álló) pályán, melyen alapból az első mezőn 4 játékos áll, és a maradék mezőkön 2 medve véletlenszerűen van elhelyezve.

Mivel egy teszt futási ideje változó, minden feltüntetett teszteredmény 5 db teszt futási idejének átlaga. Az idő után az üres teszthez képest mért növekedés van feltüntetve.

**Üres teszt**
- Játék indítása alapbeállítások mellett: `1,309s`

## Medvék számának növelése

**Leírás**  

Ebben a tesztben az egyszerre játékban lévő medvék számát próbáltuk megnövelni. 

Sajnos a játék működése miatt van egy beépített korlátozás a medvék számára vonatkozóan: ha egy medve egy olyan mezőre akar lépni, ahol egy másik medve már áll, másik mezőt kell választania. Ezt addig ismétli amíg egy üres mezőt nem talál. Emiatt a maximális medve szám a mezők számával egyezik meg, így csak ezzel tudtunk tesztelni. Alapból már van két medve, ezért ez a tesztben **33** darab medvét használhatunk.

Ha ezt a maximális számot kihasználjuk, abba a hibába ütközünk, hogy egy medve biztosan rákerül arra a jégtáblára, amin a játékosok állnak. Ebben az esetben a játéknak vége, mivel lehelyezéskor a medve mindig megtámadja az adott mezőn lévő játékosokat. Ez az esemény lehet, hogy az összes medve lerakása (és mgejelenítése) előtt történik meg, ezért a teszt nem valós betöltési időt fog mérni. Ezt elkerülendő, csak a mezők számánál egyel kevesebb medvét rakunk le, és hogy a játékosok mezőjére még így se kerülhessen medve, azzal a mezővel megbontjuk az összes szomszédsági viszonyt, így a medvék nem tudnak véletlenszerűen oda jutni. Tehát a teszt maximum **32** medvét használhat.

**Tesztek**

- Játék indítása 32 db medvével: `1,322s` **+1%**
- Játék indítása 33+ db medvével: `StackOverflow`

**Következtetések**

- A medvék száma (a megengedett tartományon belül) gyakorlatilag nem befolyásolja a töltési időt.

## Játékosok számának növelése

**Leírás**  

Játékosok esetén nincs korlátozás arra, hányan állhatnak egy mezőn, ezért ezzel értelmesebb teszteket lehet végezni.  

**Tesztek**

**Következtetések**

## Tárgyak számának növelése

**Leírás**  

Kétféle tárgy van a játékban: Frozen és Floating:
- Frozen: jégtáblába van fagyva, nem látszik a UI-n  
- Floating: a jégtábla felszínén van , látszik az UI-n

Mindkét tárgytípus számának növelésére külön teszteket futtattunk.

**FrozenItems Tesztek**

- Játék indítása jegenként 1.000 db fagyott tárggyal: `1,316s` **+0,5%**
- Játék indítása jegenként 100.000 db fagyott tárggyal: `1,534s` **+17,2%**
- Játék indítása jegenként 1.000.000 db fagyott tárggyal: `3,339s` **+155,1%**
- Játék indítása jegenként 1.550.000 db fagyott tárggyal: `8.918s` **+581,3%**
- Játék indítása jegenként 1.560.000 db fagyott tárggyal: `java.lang.OutOfMemoryError`

**FloatingItems Tesztek**

- Játék indítása jegenként 1.000 db lebegő tárggyal: `1,390s` **+6,2%**
- Játék indítása jegenként 100.000 db lebegő tárggyal: `2,030s` **+55,1%**
- Játék indítása jegenként 1.000.000 db lebegő tárggyal: `7,418s` **+466,7%**
- Játék indítása jegenként 1.540.000 db lebegő tárggyal: `22,739s` **+1637,1%**
- Játék indítása jegenként 1.550.000 db lebegő tárggyal: `java.lang.OutOfMemoryError`

**Következtetések**

- A játék kb. 100.000-ig jól skálázódik, utána viszont már nagy töltési idő tapasztalható.
- A két féle tárgytípus közül a FloatinItem-ek hosszabb töltési időt eredményeznek.
