import { Component, OnInit } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

     login: string;

     password: string;

    constructor(public session: SessionStorageService, private router: Router){}

    ngOnInit(): void {

    }

    onClick() {
        this.session.set("login", this.login);
        this.session.set("password", this.password);
        this.router.navigate(['/books']);
    }

}