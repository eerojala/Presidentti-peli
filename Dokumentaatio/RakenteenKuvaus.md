# Aihemäärittely

## Domain

Domain-luokat ovat periaatteessa pelivälineiden (ja itse pelaajien) vastineita.

### Ammatti, Liike, Mokki, Tutkinto.

Melko suoraviivaisia luokkia jotka sisältävät vain int- ja boolean attribuutteja sekä näiden gettereitä.

### Ruutu, Tapahtumakortti ja SelosteenOmaava.

Ruutu ja Tapahtumakortti implementoivat rajanpinnan SelosteenOmaava, joka vaatii implementoivilta luokilta metodit
get- ja setSeloste. Ruudut ja Tapahtumakortit molemmat omaavat siis selosteet jotka näytetään pelaajalle astuttaessa 
ruudulle/nostettaessa tapahtumakortit. Yhteistä ruuduille ja tapahtumakorteille on myös se, että molemmat sisältävät
listan tapahtumia. Ruutu sisältää myös logiikalle olennaisia boolean-arvoja, sekä xy-koordinaatit int-muodossa jota
GUI tarvitsee nappuloiden piirtoa varten.

### Nappula

Pitää muistissaan sen omistaavaa pelaajaa, ruutua jossa tällä hetkellä sijaitsee sekä kuvatiedostoa joka piirretään 
GUI:hin.

### Pelaaja

Luokka joka sisältää pelaajan nykyisen ammatin, omistamat liikkeet ja mökit, rahat ja velat, tutkinnon, nimen, nappulan
sekä int arvon joka kertoo montako kierrosta pelaaja joutuu odottamaan ennen seuraavaa vuoroaan. (Oletuksena 0). Luokka
sisältää myös logiikan kannalta olennaisia boolean-arvoja.

### Pelilauta

Pitää sisällään listoja ja pinoja kaikista domain-olioista jotka eivät ole pelaajien hallussa. Omistaa myös kuvatiedoston
joka piirretään GUI:hin.


## Domain.tapahtumat

Sisältää runsaasti abstraktin luokan Tapahtuma- periviä luokkia. Tapahtumaluokkia on sen verran paljon että niitä
ei viitsi yksitellen selittää, mutta kaikille tapahtumaluokille yhteistä on metodi suoritaTapahtuma(Pelaaja pelaaja),
joka vaikuttaa jotenkin pelaajan omaisuuteen tai tilanteeseen, esim "Siirrä pelaajan nappulaa ruutuun X" tai "Anna
pelaajalle rahaa 1000mk". Tapahtumaluokat on pääaisiassa tarkoitettu liitettäväksi ruutuihin ja tapahtumakortteihin
jotta niitä voisi vaivattomasti suorittaa logiikan puolella tyyliin "for Tapahtuma tapahtuma : ruutu.getTapahtumat()",
mutta jotkin logiikkaluokat luovat itse tapahtumaluokkia, pääasiassa sellaisissa tilanteissa joissa tarvitaan pelaajan
interaktiota, esim "Pelaaja haluaa myydän mökin X".

## Logiikka

### Eduskuntavaalienhallinta, OstoJaMyynti, PelaajanStatus, Presidentinvaalienhallinta ja Velanhallinta.

Erillisten pienten GUIden käyttämät logiikkaluokat jotka keräävät tietoa nykyisestä pelaajasta ja käsittelevät pelaajan
tekemiä päätöksiä GUIssa ja välittävät ne muille logiikkaluokille.

### Aloitus

Luokka joka tarkistaa AloitusGUIlle syötettyjen nimien oikeellisuuden. (Nimien tulee olla 1-24 merkkiä pitkiä ja
keskenään erilaisia).

### KaikenLuoja.

Luokka joka luo pelin tarvitsemat domain-oliot sekä päälogiikkaluokan Peli luojaluokkien avulla.

### Kiinteistonvalittaja.

Käsittelee mökkejä ja liikkeitä. Antaa pelaajalle mökkejä ja liikkeitä laudalta, tai vie niitä takaisin laudalle
pelaajalta.

### Liikuttelija

Liikuttaa pelaajien nappuloita laudalla.

### Pankinjohtaja

Huolehtii pelaajan rahasta ja velasta, sekä antaa uuden kierroksen alkaessa pelaajalle kuukauden tuotot.

### PelajaanStatus

Kerää tietoa nykyisestä pelaajasta.

### Peli

Pelin päälogiikkaluokka. Huolehtii ruutujen tapahtumien suorittamisesta ja pelaajien pelistä tiputtamisesta, sekä pitää
muistissaan tällä hetkellä vuorossa olevaa pelaajaa. Jos nykyinen pelaaja astuu erikoisruutuun, käskee luokka avaamaan
kyseisen erikoisruudun GUIn.

### Putka

Asettaa pelaajat odottamaan vuoroaan 2 kierroksen ajaksi.

### Vaalienjarjestaja.

Huolehtii eduskunta- ja presidentinvaalien järjestämisestä. Asettaa parametrinaan saamaansa pelaajan kansanedustajaksi
tai ilmoittaa hänen voittaneen pelin mikäli vaalit onnistuvat.

### Vuoronvaihtaja

Vaihtaa pelaajien välillä vuoroa.



## Logiikka.luojat

Näiden luokkien vastuulla on luoda pelin tarvitsemat Domain-oliot. Jotkut näistä luojaluokista lukevat olioiden
parametreja tekstitiedostoista. Luojaluokat perivät abstraktin luokan Luoja, joka määrittää metodin public abstract
void Luo() ja protected void asetaScannerilleTiedosto(String tiedostopolku, ClassLoader classloader) joka asettaa
Scanner-attribuutille luojaluokan käyttämän tiedoston.



## Util

### Kuvanlaataaja

Luokka asettaa BufferedImage-oliolle parametrina saadusta tiedostopolusta ladatun kuvatiedoston ja palauttaa sen.
Pelilaudan ja nappuloiden luojaluokkien käyttämä.

### SelosteenAsettaja

Asettaa SelostenOmaava-rajapinnan implementoiville olioille selosteet. Ruutujen ja tapahtumakorttien logiikkaluokkien
käyttämä.



## GUI

### AloitusGUIlle

Kysyy käyttäjältä halutun pelaajien määrän väillä 2-6 sekä näiden nimet. Jos nimet ovat oikeellisia avaa pelin pääGUIn.

### EduskuntavaalienhallintaGUI

Kysyy käyttäjältä paljon hän haluaa käyttää rahaa eduskuntavaaleihin. Mitä enemmän rahaa pelaaja käyttää, sitä helpompi
on hänen voittaa vaalit. Avautuu kun pelaaja astuu ruudulle 10.

### OstoJaMyyntiGUI

Näyttää pelaajalle laudan kortitpinojen päälimmäisen mökin ja liikkeen sekä pelaajan omistamat mökit ja liikkeet.
Pelaaja voi halutessaan ostaa/myydä liikkeen/mökin. Avautuu kun pelaaja astuu ruudulle 1, 16 tai 20.

### PelaajanStatusGUI

Näyttää vuorossa olevan pelaajaan liittyvät tiedot. Avautuu kun pelaaja painaa PeliGUIssa status-nappia.

### PeliGUI.

Pelin pääGUI. Näyttää kuvana laudan ja siellä sijaitsevat nappulat ja niiden sijainnit. Pelaaja pystyy heittämään noppaa
jonka silmäluvun verran logiikka liikuttaa nappulaa eteenpäin, vaihtamaan nopanheiton jälkeen vuoroa, ja avaamaan Status-
ja VelanhallintaGUIn.

### Piirtoalusta

PeliGUIn käyttämä JPanelin perivä luokka, joka piirtää pelilaudan ja nappulat ruudulle.

### PresidentinvaalienhallintaGUI

Kysyy pelaajalta minkä vaalikamppanjan hän valitsee presidentinvaaleihin. Avautuu kun pelaaja astuu ruudulle 30 ja hän
kykenee vähintään yhteen vaalikamppanjavaihtoehtoon. Jos pelaaja voittaa vaalit, ohjelman suoritus päättyy.

### PutkakyselyGUI

Kysyy pelaajalta haluaako hän mielummin maksaa 4000mk vai istua putkassa 2 vuoron ajan. Avautuu kun pelaaja astuu
astuu ruudulle 24 ja hänellä on vähintään 4000mk. Jos pelaajalle ei ole vähintään 4000mk peli automaattisesti asettaa
hänet putkaan.

### Ruutu25KyselyGUI

Kysyy pelaajalta haluaako hän suorittaa eduskuntavaalit. Avautuu kun pelaaja astuu ruudulle 25 ja hän on puolueen jäsen
sekä on ammatissa jonka palkka on vähintään 4000 mk/kk.

### VelanhallintaGUI

GUIn avulla pelaaja pystyy maksamaan velkojaan takaisin tai ottamaan sitä lisää. Avautuu jos pelaaja painaa PeliGUIssa
velanhallinta-nappia tai jos pelaaja joutuu maksamaan enemmän rahaa mitä omistaa.