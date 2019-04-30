import { Component, OnInit, Input } from '@angular/core';

import { IBook, IPageData } from '../../shared/interfaces';

@Component({
    selector: 'app-books-pagination',
    templateUrl: './books-pagination.component.html',
    styleUrls: ['./books-pagination.component.css']
})
export class BooksPaginationComponent implements OnInit {

    private _pageDetail : IPageData;
    private _queryNext : any;
    private _queryPrev : any;
    prev : any;
    next: any;
    current: any;
    first: boolean;
    last: boolean;


    @Input() get pageDetail(): IPageData{
        return this._pageDetail;
    }
    
    set pageDetail(value: IPageData) {
        if (value) {
            this._pageDetail = value;

            this._queryNext = {} ;
            this._queryNext.page = value.next;
            this._queryNext.q = value.q;

            this._queryPrev = {} ;
            this._queryPrev.page = value.prev;
            this._queryPrev.q = value.q;
            this.prev = this._pageDetail.prev;
            this.next = this._pageDetail.next;
            this.current = this._pageDetail.current;
            this.first = this._pageDetail.first;
            this.last = this._pageDetail.last;
        }
    }

    ngOnInit() {

    }

}