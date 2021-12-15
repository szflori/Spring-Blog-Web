# Kötelező program
## Feladatleírás
A kötelezően megvalósítandó program egy __blog__ alkalmazás. A blognak a következő elemekkel, funkciókkal kell rendelkeznie:

- Blog bejegyzés írása/szerkesztése/törlése
- Blog bejegyzések listázása (kronológiai sorrendben)
- Keresés a blogbejegyzések között:
  - Alap keresés: blogpost címe alapján
  - Részletes keresés: bejegyzés szövegében, szerző neve, dátum (tól-ig)
- Minden blogbejegyzésnek rendelkezik a következőkkel:
  - Cím
  - Létrehozás dátuma
  - Blogbejegyzés szerzője
  - Kategória vagy kategóriák (külön entitásként kezeljük)
- A rendszerben minden felhasználó rendelkezik a következő tulajdonságokkal
  - Név (kötelező)
  - Email cím (kötelező)
  - Jelszó (kötelező)
  - Profilkép (opcionális)
  - Születési dátum (opcionális)
  - Aktív-e
- A kategóriák csak egy névvel rendelkeznek
- A blogbejegyzésekhez lehet kommenteket írni
- A blogbejegyzéseket és a kommenteket lehet kedvelni/nem kedvelni

### A blog alkalmazásban 3 szerepkör van jelen:

- Vendég 
  - Csak olvasni tudja a blogot, illetve keresni, továbbá látja a felhasználók profiljait
- Regisztrált felhasználó
  - Írhat saját bejegyzést, melyet szerkeszthet/törölhet is
  - Like-olhat bejegyzést, kommentet
  - Profil oldal
- Adminisztrátor
  - Bármit szabadon létrehozhat/módosíthat/törölhet/listázhat a felületen
  - REST API használat
    - Alapműveletek támogatása (létrehozás, listázás, törlés, módosítás)
    
### A megvalósítás során követendő további követelmények:

- Regisztráció támogatása
- Bejelentkezés támogatása
- A jelszavak kódolva történő tárolása
- Az autentikáció ne egyszerű HTTP Basic auth legyen
- A fejlesztés során legyen legalább két profil alkalmazva:
  - dev (H2 DB-t használjon)
  - prod (MySQL, PostgreSQL használat)
- Ahol van értelme ott tranzakcionális műveletek támogatása
- Az adat réteget Spring Data technológiával oldjuk meg (Spring JPA, Spring JDBC)
- Az összes entitáshoz tároljuk a létrehozás, utolsó módosítás dátumát és személyét
- Az alkalmazás egy része legyen tesztelve (JUnit használatával)
- Az alkalmazás további bővítési lehetőségeit mindenki saját maga választhatja meg. A fenti követelményektől való eltérést előre az oktatóval kell egyeztetni!

### Technológiai megkötések
Az alkalmazást Spring Framework segítségével kell megvalósítani. Third-party library használatában nincs megkötés. A front-end legyen valamilyen Java-s template engine-el megvalósítva, legyen az:

- Thymeleaf
- FreeMarker
- Mustache
- ...

### Határidők
- `2021.10.28`: __1. mérföldkő__: Az előadás kezdetéig fel kell tölteni egy kezdeti megoldást, amely már tartalmazza a projekt vázát és a megoldás kezdeményét/terveket (kezdetleges adat osztályok, controller-ek, template-ek, stb.).
- `2021.11.18`: __2. mérföldkő__: Az előadás kezdetéig fel kell tölteni a megoldás egy olyan verzióját, amely funkcionálisan még nem teljes, de már vannak jól működő részei.
- `2021.12.06 23:59`: __3. mérföldkő__: A kötelező program leadásának végső határideje. Az utolsó előadást/gyakorlatot megelőző hétfő éjfélig fel kell tölteni a végső megoldást.
