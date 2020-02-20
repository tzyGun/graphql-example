const { RESTDataSource } = require('apollo-datasource-rest');

class BooksAPI extends RESTDataSource {
    constructor() {
        super()
        this.baseURL = 'http://localhost:8080/'
    }

    async getBookById({ id }) {
        const response = await this.get('books', { id: id });
        return this.reducer(response[0]);
    }

    async getBooks() {
        return await this.get('books')
    }

    async addBook(data) {
        const { id, name, pageCount, authorId, authorFN, authorLN } = data
        return await this.post('book/add', {
            id, name, pageCount, author: {
                id: authorId,
                firstName: authorFN,
                lastName: authorLN
            }
        })
    }
    // seriesItem is an object probivied by REST API response
    reducer(bookItem) {
        return {
            id: bookItem.id || 0,
            name: bookItem.name,
            pageCount: bookItem.pageCount,
            author: bookItem.author
        }
    }

}

module.exports = BooksAPI