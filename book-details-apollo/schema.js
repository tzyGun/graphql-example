const { gql } = require('apollo-server')

const typeDefs = gql`
schema {
    query: Query
    mutation: Mutation
}
type Mutation {
    addBook (id: ID!, name: String, pageCount: Int, authorId: String, authorFN: String, authorLN: String): Book
}
type Query {
    book(id: ID): Book
    books: [Book]
}

type Book {
    id: ID
    name: String
    pageCount: Int
    author: Author
}

type Author {
    id: ID
    firstName: String
    lastName: String
}
`

module.exports = typeDefs