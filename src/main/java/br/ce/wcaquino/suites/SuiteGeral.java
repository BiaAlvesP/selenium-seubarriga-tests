package br.ce.wcaquino.suites;

import br.ce.wcaquino.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class

})
public class SuiteGeral {
}
