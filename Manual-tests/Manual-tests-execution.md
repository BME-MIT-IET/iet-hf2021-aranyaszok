# Manual tests - execution

## __1 - Pálya inicializáció ellenőrzése__

### __A teszt végén előállt pályakép:__
 ![](Images/8.png)

```
Megjegyzés:
A teszt helyesen lefutott, a pálya megfelelően inicializálódott.
```
***

## __2 - Játékosok és körök váltakozása__

### __A teszt végrehajtása előtti pályakép:__
 ![](Images/8.png)

### __A teszt végén előállt pályakép:__
 ![](Images/9.png)

```
### __Megjegyzés:__
A teszt helyesen lefutott. A pályán, a játékos átléptetése után eggyel csökkent az `Energy` értéke, a hátralévő játékosok száma csökkent eggyel az `End Turn` megnyomása után, illetve a sorban következő játékos lett az aktuális, akinek a képe bekerült az előző játékos képének a helyére.
```
***

## __3 - Játékosok mozgásának megjelenítése__

### __A teszt végrehajtása előtti pályakép:__
 ![](Images/10.png)

### __A teszt végén előállt pályakép:__
 ![](Images/11.png)

```
### __Megjegyzés:__
A teszt helyesen lefutott. A pályán, a játékos átkerült a `Move` megnyomása után az új mezőre.
```
***

## __4 - A játék mentése__

### __A teszthez a pálya előkészítése:__
 ![](Images/12.png)

### __A játék elmentése:__
 ![](Images/13.png)

### __Az elmentett játékfájl:__
 ![](Images/14.png)

```
### __Megjegyzés:__
A teszt helyesen lefutott. A mentés után a kiexportált adatfájl megjelent a kiválasztott könyvtárban.
```
***

## __5 - A játék visszatöltése__

### __A játék visszatöltése:__
 ![](Images/15.png)

### __A visszatöltött játékállapot:__
 ![](Images/16.png)

```
### __Megjegyzés:__
A teszt helyesen lefutott. A visszatöltés után a lementett állapotot kaptuk vissza.
```
***

## __6 - Jegesmedvék mozgása__

### __A játék visszatöltése:__
 ![](Images/15.png)

### __A visszatöltött játékállapot:__
 ![](Images/16.png)

```
### __Megjegyzés:__
A teszt helyesen lefutott. A visszatöltés után a lementett állapotot kaptuk vissza.
```
***