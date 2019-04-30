import { Component, OnInit } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {


    
    constructor(public session: SessionStorageService, private router: Router, private route: ActivatedRoute){}

    ngOnInit(): void {

    }

    onClick() {
        
    }

}