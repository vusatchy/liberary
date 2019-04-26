import { Component, OnInit } from '@angular/core';

import { IBook, IPageData } from '../shared/interfaces';
import { DataService } from '../core/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html'
})
export class BooksComponent implements OnInit {

    books: IBook[];
    q: string;
    page: number = 1;
    pageDetail: IPageData;
    
    constructor(private dataService: DataService , private route: ActivatedRoute) {
        route.queryParams.subscribe(val => {
            this.ngOnInit();
          });
    }
    

    ngOnInit() {
        this.route.queryParams
        .subscribe(params => {
          this.q = params.q;
        });
        
        this.route.queryParams
        .subscribe(params => {
            let p = + params.page;
            if(p) {
                this.page = p;
            }
        });

        this.dataService.getBooks(this.q ,this.page)
            .subscribe((result: any) => {
            var modal = <IPageData>{};
            
            modal.q = this.validate(this.q, "*");
            modal.current = this.page;
            modal.first = this.validate(result['first'], false);
            modal.last = this.validate(result['last'], false);
            modal.prev = this.page - 1;
            modal.next = this.page + 1; 

            this.pageDetail = modal;
            this.books = result["content"];
        });
    }

    validate(value : any , def : any) {
        if(value){
            return value;
        } else {
            return def;
        }
    }
}