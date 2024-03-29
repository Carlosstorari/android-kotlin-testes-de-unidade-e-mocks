package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class LoginActivityTest {
    @Test
    fun deveMostrarCamposDeLogin() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario) ).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha) ).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_entrar) ).check(matches(isDisplayed()))
    }
}