package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Rule
import org.junit.Test

class ProdutoTelasTest {

    //todo o teste q nao tiver uma tela definida, abrirá a tela ListaProdutosActivity
    @get:Rule
    val rule  = ActivityScenarioRule(ListaProdutosActivity::class.java)

//    @Before
//    fun setupAmbiente() {
//        AppDatabase.instancia(
//            InstrumentationRegistry.getInstrumentation().targetContext
//        ).clearAllTables()
//    }

    @Test
    fun deveMostrarONomeDoAplicativo() {
        onView(withText("Orgs"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarCamposNecessariosParaCriarUmProduto() {
        clicaNoFAB()
        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {

        clicaNoFAB()

        preencheCamposDoFormulario("Banana", "banana nanica", "6.99")

        clicaEmSalvar()

        onView(withText("Banana")).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDeEditarUmProduto() {

        clicaNoFAB()

        preencheCamposDoFormulario("Banana prata", "da feira", "6.99")

        clicaEmSalvar()

        onView(withText("Banana prata"))
            .perform(click())

        onView(withId(R.id.menu_detalhes_produto_editar))
            .perform(click())

        preencheCamposDoFormulario("Banana da terra", "Da venda", "10.99")

        clicaEmSalvar()

        onView(withText("Banana da terra")).check(matches(isDisplayed()))
    }

    private fun clicaEmSalvar() {
        onView(withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(click())
    }

    private fun clicaNoFAB() {
        onView(withId(R.id.activity_lista_produtos_fab))
            .perform(click())
    }

    private fun preencheCamposDoFormulario(
        nome: String,
        descricao: String,
        valor: String
    ) {
        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.replaceText(nome),
                ViewActions.closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.replaceText(descricao),
                ViewActions.closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.replaceText(valor),
                ViewActions.closeSoftKeyboard()
            )
    }

}