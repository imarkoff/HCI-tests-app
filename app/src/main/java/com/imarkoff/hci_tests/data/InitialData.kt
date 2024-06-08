package com.imarkoff.hci_tests.data

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel

@Composable
fun InsertInitialTest() {
    val testViewModel: MainViewModel = viewModel(factory =  MainViewModel.factory)

    val questions: List<Question> = listOf(
        Question(
            questionText = "Що таке людинно-машинна взаємодія?",
            answers = listOf(
                Answer(answerText = "Це галузь науки, яка вивчає взаємодію людей з комп'ютерами та іншими машинами.", isCorrect = true),
                Answer(answerText = "Це тип програмного забезпечення, яке використовується для управління комп'ютером.", isCorrect = false),
                Answer(answerText = "Це мережа комп'ютерів, яка дозволяє людям обмінюватися інформацією.", isCorrect = false),
                Answer(answerText = "Це тип комп'ютера, який використовується для виконання складних завдань.", isCorrect = false),
            )
        ),
        /*Question(
            questionText = "Які основні цілі взаємодії людини з комп'ютером?",
            answers = listOf(
                Answer(answerText = "Ефективність", isCorrect = true),
                Answer(answerText = "Ефективність, задоволення, безпека", isCorrect = false),
                Answer(answerText = "Ефективність, задоволення, безпека, зручність", isCorrect = false),
                Answer(answerText = "Ефективність, задоволення", isCorrect = false),
            )
        ),
        Question(
            questionText = "Які існують принципи взаємодії людини з комп'ютером?",
            answers = listOf(
                Answer(answerText = "Прямість, відповідність, зручність, надійність", isCorrect = true),
                Answer(answerText = "Прямість, відповідність, зручність", isCorrect = false),
                Answer(answerText = "Прямість, відповідність", isCorrect = false),
                Answer(answerText = "Прямість", isCorrect = false),
            )
        ),
        Question(
            questionText = "Які методи використовуються для вивчення взаємодії людини з комп'ютером?",
            answers = listOf(
                Answer(answerText = "Експерименти, спостереження, анкетування", isCorrect = true),
                Answer(answerText = "Експерименти, спостереження", isCorrect = false),
                Answer(answerText = "Експерименти", isCorrect = false),
                Answer(answerText = "Спостереження", isCorrect = false),
            )
        )*/
    )

    val test = Test(
        testName = "Тест на знання основних термінів та понять",
        testDescription = "Цей тест допоможе вам перевірити свої знання основних термінів та понять з предмету Інтерфейси та взаємодія людини з комп'ютером",
        questions = questions
    )


    testViewModel.insert(test)
}