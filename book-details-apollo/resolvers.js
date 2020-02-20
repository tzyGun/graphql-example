
const resolvers = {
    Query: {
        book: (_, { id }, { dataSources }) => dataSources.booksAPI.getBookById({ id }),
        books: (_, __, { dataSources }) => dataSources.booksAPI.getBooks(),
    },
    Mutation: {
        addBook: (_, { id, name, pageCount, authorId, authorFN, authorLN }, { dataSources }) =>
            dataSources.booksAPI.addBook({ id, name, pageCount, authorId, authorFN, authorLN })
    }
}

module.exports = resolvers