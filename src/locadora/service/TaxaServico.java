// 
// Decompiled by Procyon v0.5.36
// 

package locadora.service;

import locadora.ex.MyException;
import locadora.entites.Aluguel;
import java.util.Date;

public interface TaxaServico
{
    double taxa(final Date p0, final String p1, final Aluguel p2) throws MyException;
}
