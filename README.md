# koszyk

Aplikacja koszyk jest backendowym narzędziem dla sklepu on-line. Udostępnia 3 funkcjonalności: otwarcie koszyka,
działanie na koszyku (dodanie,usunięcie,aktualizacja przedmiotu oraz pobranie całej listy przedmiotów w koszyku),zamknięcie koszyka. 
Została napisana za pomocą Java 8 z użyciem Springa, Hibernate i Lombok.

Przed uruchomieniem aplikacji należy skonfigurować bazę danych w pliku apllication.properties.
Należy wstawić plik sql z przedmiotami w magazynie do folderu resources.

# Działanie aplikacji 
Aplikacja tworzy trzy tabele w bazie danych (Baskets, BasketItems i Storage).Tabela Baskets przechowuje informacje o koszyku ( data otwarcia koszyka,
data zamknięcia, suma przedmiotów w koszyku), tabela BasketItems przechowuje informacje o przedmiotach w koszyku (nazwę przedmiotu,
ilość przedmiotów, cene jednostkową, sume oraz ID koszyka w którym przedmioty się znajdują), tabela Storage przechowuje informacje o  przedmiotach w magazynie. Otwarcie koszyka dodaje rekord do tabeli Baskets.
Działanie na koszyku odbywa się w tabeli BasketItems. Zamknięcie koszyka aktualizuje rekord w tabeli Baskets.

# Działanie metod
Otwarcie koszyka - localhost:8080/v1/basket/open
Zwraca ID koszyka w tabeli Baskets

Zamknięcie koszyka - localhost:8080/v1/basket/close?id='a'  ,  'a' - numer ID koszyka który chcemy zamknąć z tabeli Baskets
Zwraca sume przedmiotów w koszyku.

Metody - działanie w koszyku:
Dodanie przedmiotu - localhost:8080/v1/items/add?name='a'&bId='b'&q='c'   , 'a' - nazwa przedmiotu, 'b' - numer ID koszyka do którego dodajemy przedmiot
Zwraca ID przedmiotu w tabeli BasketItems                                   'c' - ilość przedmiotu

Aktualizacja przedmiotu - localhost:8080/v1/items/update?itemId='a'&q='b' , 'a' - ID przedmiotu w tabeli BasketItems, 'b' - nowa ilość przedmiotu

Usunięcie przedmiotu - localhost:8080/v1/items/delete?itemId='a'          , 'a' - ID przedmiotu w tabeli BasketItems który chcemy usunąć

Pokazanie listy przedmiotów w koszyku 
localhost:8080/v1/items/showBasket?bId='a'       , 'a' - ID koszyka z tabeli Baskets 

Cały czas aplikacja jest poprawiana. 

