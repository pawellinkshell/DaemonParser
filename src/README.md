**Simple Aplication Framework for CommandLine**

Aplikacja ma za zadanie pilnować porządku uruchamiania aplikacji w modelu trójwarstwowym, czyli
aplikacja posiada:

* Warstwę prezentacji       (UI)    // tzw. Widok
* Warstwę logiki biznesowej (BLL)   // 
* Warstwę dostępu do danych (DAL)   // tzw. Model

**Pisana aplikacja z tym frameworkiem powinna spełniać:**
* Jedna, jedyna adnotacja `@Runner` na klasie w celu uruchomienia tylko 1 aplikacji
* Jedna, jedyna adnotacja `@Flow` na klasie w która także implementuje `ApplicationFlow`, 
która jest odpowiedzialna za dostarczenie 3 metod, `prepare(...)`, `run(...)` oraz `quit(...)`   