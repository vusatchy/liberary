import { first } from 'rxjs/operators';

export interface IBook {
    id: number;
    title: string;
    author: string;
    year: number;
    publisher: string;
    small: string;
    midle: string;
    large: string;
}

export interface IPageData {
    q: string;
    current: number;
    next: number;
    prev: number;
    last: boolean;
    first: boolean;
}
