import {Component } from '@angular/core'

@Component({
    selector: 'hello',
    templateUrl: './hello.component.html'
})
export class HelloComponent {

    nome: String;
    Clientes: Cliente[];
    
    constructor(){
        this.nome= 'renato'
        let renato = new Cliente('renato', 22);
        let joao = new Cliente('joao', 16)

        this.Clientes=[renato, joao];
    }
}

class Cliente{

constructor(
    public nome: String,
    public idade: Number

){}

}