import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import swal from 'sweetalert2';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  errors: string[];

  constructor(private apiService: ApiServiceService,
              private router: Router) { }

  ngOnInit() {
  }
  registro(username, password, name, lastName, email) {
    const user = new User();
    user.username = username;
    user.password = password;
    user.firstName = name;
    user.lastName = lastName;
    user.email = email;
    console.log(user);
    this.apiService.registerUser(user)
      .subscribe(
        user => {
          this.router.navigate(['/auth/login']);
        },
        err => {
          this.errors = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
          this.router.navigate(['/auth/login']);
        }
      );
  }
}
