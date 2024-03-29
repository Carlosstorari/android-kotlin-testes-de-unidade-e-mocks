package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Test

class FormularioCadastroUsuarioTest {

    @Test
    fun deveMostrarCamposDeCadastro() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_email)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario))
            .perform(
                ViewActions.typeText("Harry"),
                ViewActions.pressBack()
            )
        onView(withId(R.id.activity_formulario_cadastro_email))
            .perform(
                ViewActions.typeText("harry@gmail.com"),
                ViewActions.pressBack()
            )
        onView(withId(R.id.activity_formulario_cadastro_senha))
            .perform(
                ViewActions.typeText("123456"),
                ViewActions.pressBack()
            )
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .perform(ViewActions.click())

    }
}