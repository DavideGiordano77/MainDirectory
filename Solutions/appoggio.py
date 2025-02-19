Controllo dati

# Verificare la struttura del dataset
df.info()

# Contare i valori mancanti per colonna
df.isnull().sum()

# Controllare se ci sono duplicati
df.duplicated().sum()


Rimuovere o gestire i valori mancanti

# Opzione 1: Eliminare le righe con valori mancanti
df = df.dropna()

# Opzione 2: Sostituire i valori mancanti (es. con la media o un valore specifico)
df["colonna"].fillna(df["colonna"].mean(), inplace=True)

# Opzione 3: Sostituire valori mancanti con un valore predefinito
df["colonna"].fillna("Sconosciuto", inplace=True)

# Elimina duplicati
df = df.drop_duplicates()

# Correggere i tipi di dati
df["colonna_numerica"] = pd.to_numeric(df["colonna_numerica"], errors="coerce")  # Convertire in numero
df["colonna_data"] = pd.to_datetime(df["colonna_data"], errors="coerce")  # Convertire in data


Pulire i testi (spazi, maiuscole, formati)

# Rimuovere spazi bianchi nei nomi delle colonne
df.columns = df.columns.str.strip()

# Convertire testo in minuscolo
df["colonna_testo"] = df["colonna_testo"].str.lower()

# Eliminare spazi bianchi in eccesso nelle stringhe
df["colonna_testo"] = df["colonna_testo"].str.strip()


Salva il file pulito

df.to_csv("file_pulito.csv", index=False)

Connettersi a postgresqlfrom sqlalchemy import create_engine

# Configura la connessione al database (sostituisci con i tuoi dati)
DATABASE_URL = "postgresql://user1:mypassword@192.168.1.100:5432/movies_db"

# Crea il motore di connessione
engine = create_engine(DATABASE_URL)

Caricare i dati puliti
# Scrive il DataFrame in PostgreSQL (sostituisci 'movies' con il tuo nome tabella)
df.to_sql("movies", engine, if_exists="replace", index=False)

print("Dati caricati con successo in PostgreSQL!")

