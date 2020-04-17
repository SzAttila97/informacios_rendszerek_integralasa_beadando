# Információs rendszerek integrálása beadandó
Szilvási Attila - PILPA5
_____________
Feladat:

Készítsen REST API-t, amely egy könyvtár adatbázisát használja. Készítsen egy Angular klienst, amely könyveket tud hozzáadni az adatbázishoz. Készítsen, a kölcsönzéshez használható funkciót, amely a könyveket kikölcsönzött, illetve visszavitt státuszra állítja. Listázza a kikölcsönzött és kölcsönözhető könyveket.
_____________
Megvalósítás:


Backend:
Spring framework használata a REST API elkészítéséhez.


Frontend:
Angular-9 + Angular Material használata a webkliens elkészítéséhez.


DB:
MySQL használta az adatbázis elkészítéséhez.


* Adatbázis elindítása
  * Futtatásra kész MySQL szerver legyen telepítve a rendszeren.
  * Indítsjuk el, majd futtasuk le rajta az SQL scripteket.
  * Hozzunk létre és adjunk megfelelő jogokat az adatbázishoz.
  
* Backend szerver (REST API)
  * A backend projeket importáljuk az IDE-be, ennek fel kell ismernie, hogy mave -nes projekt.
  * A main függvényt tartalmazó osztály futtatásával elindul a szerver.
  
* Frontend (Webkliens)
  * NPM csomagkezelő telepítése szükséges.
  * Futtassuk az NPM INSTALL -t illetve az NPM START-ot, igy elindul a webkliensünk.
  * http://localhost:4200 címen érhető el a kliens.
