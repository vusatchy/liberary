import { Component, OnInit } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

     login: string;

     password: string;

     error: boolean;

     message: string;

    constructor(public session: SessionStorageService, private router: Router, private route: ActivatedRoute){}

    ngOnInit(): void {
        this.route.queryParams
        .subscribe(params => {
          this.error = this.toBoolean(params.error);
          if(this.error) {
              this.message = "Invalid login or password"
          }
        });
    }

    onClick() {
        this.session.set("login", this.login);
        this.session.set("password", this.password);
        this.router.navigate(['/books']);
    }

    toBoolean(xxx: any): boolean {
        if(xxx) {
          const xStr = xxx.toString().toLowerCase().trim();
          if(xStr === 'true' || xStr === 'false') {
            return xStr === 'true' ? true : false;
          } else {
            return xxx ? true : false;
          }
        } else {
          return false;
        }
    }

}