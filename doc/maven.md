# Build keretrendszer beüzemelése, ha még nincs (Maven, Gradle...) + CI beüzemelése, ha még nincs (Actions, Travis, AppVeyor, Azure Pipelines...)

Az alkamazásunk könyvtár struktúrája nem egyezett meg a maven által elő írt könyvtár struktúrával. Először is ezt kellett módosítani. Létrehoztuk a main és a tesztek számára is a megfelelő könyvtárakat/package-eket. 

Az alkamazásunk a módosítások után nem indult megfelelően. Mint kiderült az új pálya generálása nem működött megfelelően. A hiba forrása a java bináris szerializálására vezethető vissza, ugyanis a pálya generálásakor egy ilyen binárist olvasunk be, melyben már van egy előreösszeállított félkész pálya. Ezt a pályát módosította a kód az éppen generált módosítások alapján, majd elindult a játék. De mivel változott az játékot vezérlő gameManager osztály package strutúrája, a binárist nem tudta megfelelően castolni és hibával leált a program.

A hibát tudtuk orvosolni. Létrehoztunk a GameManager osztályon belül egy saját fileReadert, ami a beolvasott binárison lecserélte a package nevet.

A hiba javítása után github-on az actions fül alatt létrehoztuk a maven-hez szükséges yaml fájlt. A maven futás közben a java jdk 11-es verziót használja, illetve a junit tesztekhez futtatásához a junit 5.*.* verzióját importálja.

A test könyvtárban létrehoztuk legelső tesztünket, a MyFirstTest osztályban, hogy megbizonyosodjunk róla hogy a teszt valóban lefutni minden commit után.

## A feladat megoldói
Bodó István - LU93RR <br>
Nagy Márton - DMMP94 <br>
A feladatot közel ~4-5 óra volt megoldani