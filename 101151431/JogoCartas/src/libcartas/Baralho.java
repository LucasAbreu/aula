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

package libcartas;

import exception.InvalidValueException;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Classe que implementa o conceito de um baralho de 52 cartas
 */
public class Baralho {
    
private LinkedList<Carta> cartas;
    
    /**
     * Método contrutor que inicializa um Baralho de 52 cartas
     */
    public Baralho(){
        
        this.criaBaralho(52);
        
    }
    
    /**
     * Método que cria um baralho com um dado número de cartas divididas entre espadas, copas, paus e ouros 
     * @param numero 
     */
    public void criaBaralho(int numero){
        
        LinkedList<String> naipes=new LinkedList<String>();
        naipes.add("espadas");
        naipes.add("copas");
        naipes.add("paus");
        naipes.add("ouros");
        
        this.cartas = new LinkedList<Carta>();
            
        for(int x=0; x<naipes.size(); x++) {
                
            for(int i=0;i<numero/4;i++){
                    
                cartas.add(new Carta(i+1, naipes.get(x)));
                    
            }
        
        }
        
    }
    
    /**
     * Método que embaralha as cartas do baralho de maneira aleatória
     */
    public void embaralhar(){
        
        Collections.shuffle(cartas);
        
    }
    
    /**
     * Método que parte o baralho em duas partes, pondo a parte final à frente da parte inicial
     * @param valor
     * @throws InvalidValueException 
     */
    public void cortar(int valor) throws InvalidValueException{
        
        if(valor < 0) {
            throw new InvalidValueException("Número de corte deve ser maior que zero");
        } 
        
        else {

            if(cartas.size() < valor) {
                throw new InvalidValueException("Número de corte deve ser menor que o número de cartas");
            }

            else{
            
                LinkedList<Carta> temp = new LinkedList<Carta>();
        
                for(int i=valor;i<cartas.size();i++) {
                    temp.add(cartas.get(i));
                }

                for(int i=0;i<valor;i++) {
                    temp.add(cartas.get(i));
                }
        
                Collections.copy(cartas, temp);
                
            }
            
        }
        
    }
   
    /**
     * Método que remove e retorna uma carta do início do baralho
     * @return 
     */
    public Carta retiraInicio(){
        
        return cartas.removeFirst();
        
    }
    
    /**
     * Método que remove e retorna uma carta do fim do baralho
     * @return 
     */
    public Carta retiraFim(){
        
        return cartas.removeLast();
    
    }
    
    /**
     * Método que remove uma carta do início e a insere no fim do baralho
     */
    public void passaCartaInicioParaFim() {
        
        cartas.addLast(cartas.removeFirst());
        
    }
    
}