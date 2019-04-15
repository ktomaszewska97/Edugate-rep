# Edugate_rep

## Install
1. mkdir folder_name
2. cd folder_name
3. git clone 
4. npm install
5. npm run
6. load http://localhost:3000/

## Backend

Aplikacja od strony backendu używa technologii Spring MVC. Projekt Edugate zawiera 8 paczek plików: config, controller, exception, model, payload, repository, security oraz util. 

### Config
Config zawiera klasy odpowiedzialne za zapewnienie właściwej konfiguracji systemu w celu właściwej współpracy z bazą danych i frontenedem oraz ustawienia autoryzacji logowania użytkownika.

### Controller
Controller zawiera klasy odpowiedzialne za obsługę zapytań z frontendu. Stanowi API do łączenia się z bazą danych; przy użyciu metod CRUD komunikuje się z bazą. Każde żądanie z frontendu charakteryzuje konkretny ciąg URL, który informuje o akcji jaka ma zostać wykonana. Jest on przechwytywany przy pomocy adnotacji @RequestMapping lub adnotacji dla konkretnych metod HTTP (@GetMappping, @PostMapping, itd.) i kierowany do odpowiedniej klasy-kontrolera, gdzie wykonywana jest właściwa metoda. 

### Exception
Exception zawiera klasy reprezentujące wyjątki jakie mogą zostać wyrzucone w trakcie działania programu. Są to: BadRequestException – w przypadku niewłaściwego żądania, OAuth2AuthenticationProcessingException – błąd autoryzacji, ResourceNotFoundException – próba odwołania się do nieistniejącego zasobu w bazie danych. 

### Model
Model zawiera klasy będące zmapowanymi odpowiednikami encji w bazie danych. Umożliwiają konwersję danych z bazy (rekordów) na konkretne, odpowiadające im, obiekty w javie. 

### Payload
Payload zawiera klasy opakowujące (tzw. wrappery) dla żądań z frontendu oraz odpowiedzi 
z systemu. 

### Repository
Repository zawiera interfejsy używane przez Spring do obsługi operacji CRUD w bazie danych. Definiowane za pomocą adnotacji @Repository oraz rozszerzające interfejs JpaRepository domyślnie pozwalają na realizacje podstawowych i szablonowych operacji CRUD, można jednak definiować nagłówki własnych metod w celu wykonywania skonkretyzowanych operacji czytania, zapisu, usuwania i edycji w bazie. 

### Security
Security zawiera klasy obsługujące poprawną autoryzację użytkownika. 

### Util
Util zawiera klasę CookieUtils służącą do obsługi plików Cookie związanych z zapytaniem HTTP.

Dodatkowo w projekcie istnieje klasa SpringSocialApplication, zawierająca metodę main służącą do uruchomienia aplikacji. Wywołanie tej metody uruchamia silnik Spring i następuje sprawdzenie zgodności zależności (dependencies) mavena oraz przy użyciu framework’u Hibernate zgodności zadeklarowanych w modelu klas odpowiadających encjom. Poprawne uruchomienie aplikacji pozwala na interakcję z aplikacjami zewnętrznymi (m.in. frontend). 

## Frontend

### Features

### 
![alt text](https://ibb.co/1qrXyrL)
![alt text](https://ibb.co/8BCt1Pz)
![alt text](https://ibb.co/8rFzY41)
![alt text](https://ibb.co/RpybDDx)
![alt text](https://ibb.co/mzNM1jH)
![alt text](https://ibb.co/qCcD2BY)
![alt text](https://ibb.co/CMd0b7r)
![alt text](https://ibb.co/VY4QhYL)

