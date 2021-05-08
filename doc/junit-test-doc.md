# Egységtesztek készítése

## **DiggingSnowLayer Junit teszt**

- **Leírás**\
Egy Player ás egy jégtáblán, amin még van hóréteg.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy mezőn lévő hórétegek száma csökken-e.

### Lehetséges hibák:
- A jégtáblán nem csökken a hóréteg
- A hóréteg csökkentése helyet egy tárgyat ás ki a jégtáblából

### Elvárt eredmény:

A jégen a hóréteg eggyel csökken.

## **DiggingItem Junit teszt**

- **Leírás**\
Egy Player ás egy jégtáblán, amin már nincs hóréteg, és kiás egy Item-et.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a mezőből az ásás hatására egy Item kikerül-e a FrozenItem-ek közül (ha még van) és bekerül a FloatingItem-ekhez.

### Lehetséges hibák:
- Nem kerül ki Item a jégtáblára akkor se ha van még Item a jégtáblában
- Több Item kerül ki egy ásással
- A kiásott Item nem kerül a FloatingItem-ekhez
- A kiásott Item nem tűnik el a FrozenItem-ek közül

### Elvárt eredmény:

Az Item amit kiástunk a FrozenItem-ek közül a FloatingItem-ekhez kerül.

## **DiggingItemWithEmptyFrozenItemsList Junit teszt**

- **Leírás**\
Egy Player ás egy jégtáblán, amin már nincs hóréteg, és kiás egy Item-et.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a mezőből az ásás hatására egy Item kikerül-e a FrozenItem-ek közül (ha még van) és bekerül a FloatingItem-ekhez.

### Lehetséges hibák:
- Nem kerül ki Item a jégtáblára akkor se ha van még Item a jégtáblában
- Több Item kerül ki egy ásással
- A kiásott Item nem kerül a FloatingItem-ekhez
- A kiásott Item nem tűnik el a FrozenItem-ek közül

### Elvárt eredmény:

Nem kerül új Item FloatingItem-ekhez.

## **DropAnItem Junit teszt**

- **Leírás**\
Egy Player lehelyez egy Item-et a saját jégtáblájára
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk hogy a játékos tárgykészletéből eltűnt-e és a jégtábla FloatingItems listájába került-e az eldobott Item.

### Lehetséges hibák:
- A tárgy benne marad a játékos tárgykészletében
- A tárgy nem kerül a FloatingItems listájába de eltűnik a játékos tárgykészletéből

### Elvárt eredmény:

Az Item a játékostól eltűnik és a FloatingItems listájába került.

## **PickUpAnItem Junit teszt**

- **Leírás**\
Egy Player felvesz egy Item-et a saját jégtáblájáról.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk hogy a játékos tárgykészletébe került-e és a jégtábla FloatingItems listájából eltűnt-e
a felvett Item.

### Lehetséges hibák:
- A tárgy nem kerül be a játékos tárgykészletébe, de a FloatingItems listájából eltűnt
- A tárgy amit felvettünk nem tűnik el a FloatingItems listájából

### Elvárt eredmény:

Az Item a FloatingItems listájából ajátékostól került.

## **EskimoSkillOnIceWhitTent Junit teszt**

- **Leírás**\
Az Eskimo használja a Skill-jét olyan jégen, amin Tent van.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk hogy azon a mezőn, amin az Eskimo áll, a Skill használata után Iglu áll-e, nem pedig Tent.

### Lehetséges hibák:
- Az Iglu nem jön létre a jégtáblán továbbra is a Tent van ott

### Elvárt eredmény:

A jégtáblán a building egy iglu lesz.

## **ITManSkill Junit teszt**

- **Leírás**\
Az Informatikus használja a képességét, megissza a Pálinkát.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a mezőn álló játékosok élete maximális lesz-e és hogy a Palesz eltűnt-e a játékos tárgykészletéből.

### Lehetséges hibák:
- Nem az összes játékos testhője lesz maximum
- Nem lesz maximum a játékosok testhője
- A Palesz nem tűnik el a ITMan tárgykészletéből

### Elvárt eredmény:

A jégtáblán lévő összes játékos hp-je maximum lesz.

## **ResearcherSkill Junit teszt**

- **Leírás**\
A Sarkkutató használja a képességét, megvizsgálja egy szomszédos mező teherbírását.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a mező teherbírása megegyezik e azzal, amit a sarkkutató eredményül kapott.

### Lehetséges hibák:
- A Researcher rossz értéket kap vissza a teherbírásról
- Nem kap semmilyen értéket

### Elvárt eredmény:

A jégtábla kutatott változója igaz lesz.

## **StepOntoIce Junit teszt**

- **Leírás**\
Egy Player egy jégtáblára lép.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a játékos az egyik mezőből eltávolításra került, míg a másikhoz hozzáadódott.

### Lehetséges hibák:
- A játékos nem lesz eltávolítva a jégtábláról, amin állt
- A játékos el lett távolítva a jégtábláról, de nem lett hozzáadva az újhoz

### Elvárt eredmény:

A játékos átkerül a jégre.

## **StepOntoWater Junit teszt**

- **Leírás**\
Egy Player viz mezőre lép.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Azt vizsgáljuk, hogy a játékos az egyik mezőből eltávolításra kerül, míg a másikhoz hozzáadódik.

### Lehetséges hibák:
- A játékos nem lesz eltávolítva a jégtábláról amin állt
- A játékos el lett távolítva a jégtábláról de nem lett hozzáadva a vízhez

### Elvárt eredmény:

A játékos átkerül a vízbe.

## **UseDivingSuit Junit teszt**

- **Leírás**\
Egy Player használja a DivingSuit-ot.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Használat után a safe attribútum True kell hogy legyen. A DivingSuit-nak el kell tűnnie a játékos 
tárgykészletéből.

### Lehetséges hibák:
- A safe attribútum False értékű
- A játékostól nem tűnt el a DivingSuit

### Elvárt eredmény:

A játékos safe attribútuma True értéket vesz fel.

## **UseDivingSuitWithSafeAttributeTrue Junit teszt**

- **Leírás**\
Egy Player használja a DivingSuit-ot úgy, hogy a safe attribútuma True.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A safe attribútum továbbra is True kell hogy legyen. A DivingSuit-nak el kell tűnnie a játékos 
tárgykészletéből.

### Lehetséges hibák:
- A safe attribútum False-ra változott
- A játékostól nem tűnt el a DivingSuit

### Elvárt eredmény:

A játékos safe attribútumának True értéke változatlan marad.

## **StormOnIceWithIglu Junit teszt**

- **Leírás**\
Vihar hatása jégen, amin Iglu van.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A jégen, amin Iglu van, a játékosok testhője nem csökkenhet.

### Lehetséges hibák:
- A játékosok teshője csökken

### Elvárt eredmény:

A játékos testhője nem változik, az Iglu továbbra is a jégen áll

## **UseFood Junit teszt**

- **Leírás**\
Egy Player elhasznál egy Food-ot (úgy, hogy a testhője nem maximális).
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A játékos testhője 1-el nő. A Food-nak el kell tűnnie a játékos tárgykészletéből.

### Lehetséges hibák:
- A játékos testhője nem 1-el nőtt
- A Food nem tűnt el a játékostól

### Elvárt eredmény:

A játékos élete 1 egységgel nő.

## **UseFoodOnMaxBodyHeat Junit teszt**

- **Leírás**\
Egy Player maximális testhőre használja a Food-ot.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A játékos testhője nem nőhet. A Food-nak el kell tűnnie a játékos tárgykészletéből.

### Lehetséges hibák:
- A játékos testhője nőtt, ezzel átlépve a maximumot
- A Food nem tűnt el a játékostól

### Elvárt eredmény:

A játékos élete nem változik meg.

## **UseShovelToDigSnowLayer Junit teszt**

- **Leírás**\
Egy Player használja a Shovel-t olyan jégen, ahol még
van hóréteg.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A Shovel durability-je 1-el csökken. A jégtábla snowLayers attribútuma 2-vel csökkent. Ezek után a snowLayers attribútum értéke nem lehet kevesebb, mint 0!

### Lehetséges hibák:
- A Shovel durability-je nem 1-el csökkent
- A snowLayers értéke nem 2-vel csökkent úgy, hogy értéke korábban >=2 volt
- A snowLayers értéke nem lett 0 úgy, hogy értéke korábban 1 volt
- Egy Item ki lett ásva

### Elvárt eredmény:

A jégtáblán a hóréteg 2 egységgel csökkent.

## **UseShovelToDigItem Junit teszt**

- **Leírás**\
Egy Player használja a Shovel-t olyan jégen, ahol nincs hóréteg, és kiás egy Item-et.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A Shovel durability-je 1-el csökken. A jégtábla frozenItems listájának legfelső eleme a floatingItems listába kerül.

### Lehetséges hibák:
- A Shovel durability-je nem 1-el csökkent
- A kiásott Item nem a frozenItems lista első eleme
- Nem lett Item kiásva (és a frozenItems lista nem üres)
- A kiásott Item nem került bele a floatingItems listába

### Elvárt eredmény:

A jégtáblának a FloatingItemshez kerül az új Item.

## **UseRope Junit teszt**

- **Leírás**\
Egy Player használja a Rope-ot és a saját jégtáblájára mozgatja az eltalált játékosokat.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A játékostól eltűnik a Rope. A Rope az eltalált játékosokat átmozgatja a használó játékos jégtáblájára.

### Lehetséges hibák:
- Az eltalált játékosok nem mozdulnak
- Az eltalált játékosok helytelen jégtáblára kerülnek
- Nem az összes játékos lett elmozgatva az eltalált jégtábláról
- A játékostól nem tűnt el a Rope

### Elvárt eredmény:

A vízben lévő játékos átkerül arra a jégtáblára ahol a Rope-ot használó játékos áll.

## **StormOnIceWithIglu Junit teszt**

- **Leírás**\
Vihar hatása jégen, amin Iglu van.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A jégen, amin Iglu van, a játékosok testhője nem csökkenhet.

### Lehetséges hibák:
- A játékosok teshője csökken

### Elvárt eredmény:

A játékosok teshője nem változik.

## **UseDivingSuit Junit teszt**

- **Leírás**\
Egy Player használja a DivingSuit-ot.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
Használat után a safe attribútum True kell hogy legyen. A DivingSuit-nak el kell tűnnie a játékos tárgykészletéből.

### Lehetséges hibák:
- A safe attribútum False értékű
- A játékostól nem tűnt el a DivingSuit

### Elvárt eredmény:

A játékosok safe attribútum True kell legyen.

## **UseDivingSuitWhitSafeAttributeOn Junit teszt**

- **Leírás**\
Egy Player használja a DivingSuit-ot úgy, hogy a safe attribútuma True.
- **Ellenőrzött funkcionalitás, várható hibahelyek**\
A safe attribútum továbbra is True kell hogy legyen. A DivingSuit-nak el kell tűnnie a játékos tárgykészletéből.

### Lehetséges hibák:
- A safe attribútum False-ra változott
- A játékostól nem tűnt el a DivingSuit

### Elvárt eredmény:

A játékosok inventoryából eltünik a divingsuit.

# Egységtesztek lefedettsége

![](pics\p4.png)
Ezen a képen lehet látni a egységtesztek lefedetségének százalékos értékei

Amint lehet látni, hogy az egységtesztek a kód nagy részét lefedi. A Main és a GameManager, amit nem lettek a tesztek során tesztelve és a kód nagyobb részét ez adja ezért lett az összeségben kicsi százalék a lefedettség.