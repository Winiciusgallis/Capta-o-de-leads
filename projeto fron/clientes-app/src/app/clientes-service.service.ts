import { Injectable } from '@angular/core';
import { Cliente } from './clientes/clientes-form/clientes';
import{HttpClient} from '@angular/common/http'
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
@Injectable({
  providedIn: 'root'
})
export class ClientesServiceService {

  constructor(private Http: HttpClient) {

   }
salvar( cliente: Cliente):observableToBeFn<cliente>{
return this.Http.post<Cliente>('http://localhost:3306/api?useSSL=false',cliente);
}
   getClientes() : observableToBeFn<Cliente[]>{
    return this.Http.get<Cliente[]>('http://localhost:3306/api?useSSL=false');
  }
  

  }

