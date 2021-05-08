# Manuális kód átvizsgálás elvégzése az alkalmazás egy részére + Statikus analízis eszköz futtatása és jelzett hibák átnézése (SonarCloud).
## Manuális kód átvizsgálása, észrevett hibák kijavítása
A kódon manuális átvizsgálást tartottunk, így találtunk néhány bugot:
* a kommentek ékezetes betűi a Maven-nek bezavart, így minden ékezetes betűt átírtunk ékezet nélkülire
* a játék egy régi generált pályából állt, amely serialization miatt már nem volt kompatibilis az új osztályokkal

### Pályagenerálás újraírásáról hosszabban
A régen generált pályát nem tudtuk használni, mivel olyan osztályok is le voltam sorosítva benne, amelyek megváltoztak. A változtatások oka a manuális átvizsgálás és javítás, illetve a sonar cloud által jelzett bugok javítása volt. Sajnos a generáló függvény már nem volt meg, így emlékezetből, illetve reverse engineering-gel kellett dolgoznunk a generáló függvény visszaállításához.

## Statikus analízis eszköz futtatása és jelzett hibák átnézése
Statikus analízis eszköznek a sonar cloud-ot használtuk, mivel az már ismert volt számunkra a gyakorlatokból. Első beállításra lefutásnál hibát dobott, mivel az automatikus analízis, illetve a CI is aktív volt. Hosszas próbálkozások, keresgélések után rájöttünk, hogy hol kellett kikapcsolni az automatizmust. A lefutott cloud analízise 8 bug volt elsőre, amelyeket javítottunk. Ezek kisebb hibák voltak, mint pl.:
* Random osztály példánya több függvényben is használatos volt egy osztályonn belül, újra felhasználhatóság miatt tagváltozó lett belőle
* Random osztály hasznélata nem volt teljesen helyes, ezáltal nem volt teljesen "véletlenszerü" a generált érték. Tagváltozó szintén megoldotta ezt is
* try - catch blokkok végén felesleges finally blokk szerepelt
* néhány változó nem volt tesztelve, hogy null-e, miközben lehetett az
Ezeket a bugokon kívül jópár code smell-t is kimutatott a solar cloud, amelyek töbsége a try - catch végén lévő stack kiiratása volt. Nem találtuk helyesnek a warningot, így ezeket nem javítottuk. Más code smell-ek nehezen javíthatóak voltak, hiszen mégis csak egy évvel ezelőtt írt projektünkről van szó.

## A feladat megoldói
Bodó István - LU93RR
Nagy Márton - DMMP94
A feladatot közel ~8-9 óra volt megoldani