### Структура слоев

```
com.example.surfdailyquiz/
│
├── data/                        # Слой данных
│   ├── local/                  # Room (опционально)
│   │   ├── dao/
│   │   ├── database/
│   │   └── entities/
│   ├── remote/
│   │   ├── api/                # API интерфейс
│   │   └── dto/                # DTO-объекты для Open Trivia DB
│   └── repository/            # Репозиторий
│
├── domain/                      # Бизнес-логика
│   ├── models/
│   └── usecases/
│
├── presentation/               # UI и состояние
│   ├── ui/
│   │   ├── components/        # Общие UI-компоненты
│   │   └── screens/
│   │       ├── home/          # Экран старта викторины
│   │       ├── quiz/          # Прохождение викторины
│   │       ├── result/        # Экран результатов
│   │       ├── review/        # Разбор викторины
│   │       └── history/       # История попыток
│   └── viewmodels/
│
├── di/                         # DI-модули Hilt
│
└── utils/ 
```