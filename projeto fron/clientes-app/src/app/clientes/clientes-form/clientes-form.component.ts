import { Component, onInit } from '@angular/core';
import{Router } from '@angular/router';

import { Cliente } from' ../Cliente'
import{lientesServiceService} from '../..clientesServiceService'

import { ClientesServiceService } from 'src/app/clientes-service.service';
import { Cliente } from './clientes';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements onInit {

  cliente: Cliente;
  sucess:boolean = false;
  errors:String[];

constructor(private service : ClientesServiceService,
  private router: Router ){
this.cliente = service.getCliente();
}
ngonInit(): void{

}
voltarParaListagem(){
  this.router.navigate(['/clientes-lista'])

}

onSubmit(){
  this.service.salvar(this.cliente)
  .salvar(this.cliente)
  .subscribe( response =>{
    this.sucess= true;
    this.errors= null;
    this.cliente= response;
  },ErrorResponse =>{
    this.sucess= false;
    this.errors= ErrorResponse.error.errors;
  

  }

  )
}
}
