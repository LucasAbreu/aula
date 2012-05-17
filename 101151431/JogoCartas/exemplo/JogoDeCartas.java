/**
 * <Biblioteca para manipulação de cartas.>
 * Copyright (C) <2012>  Brandon Marques dos Santos <brdonsb@gmail.com>
 * Copyright (C) <2012>  Renan Marcel Uchôa <renanmarceluchoa@gmail.com>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

package jogodecartas;

import exception.InvalidValueException;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcartas.Baralho;
import libcartas.MonteDescarte;

/**
 * Classe da aplicação que implementa um jogo de cartas simples que utiliza a API libcartas
 */
public class JogoDeCartas {
    
    public static void main(String[] args) {
        
        try {
            
            Baralho baralho = new Baralho();
            MonteDescarte descarte = new MonteDescarte();
            baralho.criaBaralho(4);
            baralho.embaralhar();
            baralho.cortar(4);
            baralho.retiraInicio();
            descarte.insereTopo(baralho.retiraInicio());
            baralho.retiraFim();
            baralho.retiraInicio();
            baralho.retiraFim();
            baralho.retiraInicio();
            baralho.retiraFim();
            descarte.mostraCartas();
            
        } catch (InvalidValueException ex) {
            Logger.getLogger(JogoDeCartas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
