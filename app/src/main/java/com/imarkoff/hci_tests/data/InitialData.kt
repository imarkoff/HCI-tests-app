package com.imarkoff.hci_tests.data

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel

@Composable
fun InsertInitialTest() {
    val testViewModel: MainViewModel = viewModel(factory =  MainViewModel.factory)

    testViewModel.insert(
        Test(
            testId = 0,
            testName = "Основні терміни та поняття",
            testDescription = "Цей тест допоможе вам перевірити свої знання основних термінів та понять з предмету Інтерфейси та взаємодія людини з комп'ютером.",
            questions = listOf(
                Question(
                    questionText = "Що таке людинно-машинна взаємодія?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Це галузь науки, яка вивчає взаємодію людей з комп'ютерами та іншими машинами.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Це тип програмного забезпечення, яке використовується для управління комп'ютером.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Це мережа комп'ютерів, яка дозволяє людям обмінюватися інформацією.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Це тип комп'ютера, який використовується для виконання складних завдань.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які основні цілі взаємодії людини з комп'ютером?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Принципи програмування, інженерії та математики.", isCorrect = false),
                        Answer(answerId = 1, answerText = "Принципи дизайну, графіки та мультимедіа.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Принципи штучного інтелекту, машинного навчання та робототехніки.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Принципи ергономіки, психології та когнітивної науки.", isCorrect = true),

                        )
                ),
                Question(
                    questionText = "Які методи використовуються для вивчення ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Експерименти, опитування та спостереження.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Моделювання, симуляції та прототипування.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Аналіз даних, машинне навчання та штучний інтелект.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які фактори впливають на взаємодію людини з комп'ютером?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Дизайн та ергономіка інтерфейсу системи.", isCorrect = false),
                        Answer(answerId = 1, answerText = "Технологічні можливості та обмеження системи.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Індивідуальні характеристики користувача, такі як вік, стать, досвід та навички.", isCorrect = true),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insert(
        Test(
            testId = 1,
            testName = "Принципи проєктування інтерфейсів",
            testDescription = "Цей тест допоможе вам перевірити свої знання про основні принципи проектування користувацьких інтерфейсів.",
            questions = listOf(
                Question(
                    questionText = "Які основні принципи проектування користувацьких інтерфейсів (КІ)?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Чіткість, простота, послідовність, естетика, ефективність.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Швидкість, потужність, гнучкість, масштабованість, безпека.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зручність, інтуїтивність, доступність, адаптивність, персоналізація.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Візуальна привабливість, інтерактивність, мультимедійність, інтеграція, надійність.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які методи використовуються для оцінки КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Тестування користувачів, аналіз експертів, когнітивні методи, опитування.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Моделювання, симуляції, прототипування, аналіз даних.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Експерименти, фокус-групи, інтерв'ю, анкетування.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які існують типи КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Командні інтерфейси, графічні інтерфейси, інтерфейси віртуальної та доповненої реальності, інтерфейси природної мови.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Інтерфейси на основі жестів, голосові інтерфейси, інтерфейси на основі сенсорних екранів, інтерфейси на основі мозкових сигналів.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Інтерфейси для веб-застосунків, мобільних застосунків, десктопних застосунків, вбудованих систем.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Як проектувати КІ для різних груп користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Проводити дослідження користувачів, щоб зрозуміти їхні потреби та очікування.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Використовувати принципи універсального дизайну, щоб зробити КІ доступними для всіх.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Проводити тестування користувачів з різними групами користувачів, щоб отримати відгуки.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які помилки часто робляться при проектуванні КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Не проводити дослідженнями користувачів.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Занадто складний дизайн.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Непослідовний дизайн.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Недоступний дизайн.", isCorrect = false),
                        Answer(answerId = 5, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insert(
        Test(
            testId = 2,
            testName = "Методи введення даних",
            testDescription = "Цей тест призначений для оцінки ваших знань про різні методи введення даних, які використовуються в комп'ютерних системах.",
            questions = listOf(
                Question(
                    questionText = "Який метод введення даних використовується для введення тексту та символів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Клавіатура", isCorrect = true),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для вибору елементів на екрані та переміщення курсору?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 1, answerText = "Миша", isCorrect = true),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = false),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення даних шляхом дотику до екрану?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 1, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = true),
                        Answer(answerId = 3, answerText = "Сканер штрих-коду", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування штрих-кодів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = true),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = false),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення голосу?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 1, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = false),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для перетворення зображень у текст?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = true),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = false),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для перетворення мови в текст?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування даних з RFID-міток?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зчитувач RFID", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування даних з магнітних смуг?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зчитувач магнітної смуги", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення даних за допомогою інших датчиків або пристроїв?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Інші методи введення даних", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insert(
        Test(
            testId = 3,
            testName = "Ергономічні принципи",
            testDescription = "Цей тест оцінює знання про ергономічні принципи. \nВін складається з 5 питань з множинним вибором, які охоплюють: фізичні та когнітивні фактори, дизайн робочого місця, устаткування та інструменти, робоче середовище, безпека та гігієна праці.",
            questions = listOf(
                Question(
                    questionText = "Який принцип стверджує, що системи та робочі місця повинні відповідати можливостям користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Універсальний дизайн", isCorrect = true),
                        Answer(answerId = 1, answerText = "Індивідуальне налаштування", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження навантаження", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення продуктивності", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип рекомендує правильне розташування монітора, клавіатури та миші?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Дизайн робочого місця, орієнтований на користувача", isCorrect = false),
                        Answer(answerId = 1, answerText = "Ергономічна робоча поза", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження ризику травм", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення концентрації уваги", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Який принцип стверджує, що інструменти та обладнання повинні бути зручними та безпечними?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Безпечний дизайн", isCorrect = false),
                        Answer(answerId = 1, answerText = "Ергономічні інструменти", isCorrect = true),
                        Answer(answerId = 2, answerText = "Зниження ризику помилок", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення точності роботи", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип рекомендує регулярні перерви та фізичну активність?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Активний відпочинок", isCorrect = true),
                        Answer(answerId = 1, answerText = "Зміна положення тіла", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження навантаження на м'язи", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення кровообігу", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип стверджує, що робоче середовище повинне бути комфортним, безпечним та сприятливим для роботи?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Сприятливі умови праці", isCorrect = true),
                        Answer(answerId = 1, answerText = "Контроль за факторами навколишнього середовища", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження ризику для здоров'я", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення самопочуття", isCorrect = false),
                    )
                )
            )
        )
    )
}