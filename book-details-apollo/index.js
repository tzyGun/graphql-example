const { ApolloServer, gql } = require('apollo-server');
const BooksAPI = require('./datasources/books')
const typeDefs = require('./schema')
const resolvers = require('./resolvers')


const server = new ApolloServer({
    typeDefs,
    resolvers,
    dataSources: () => ({
        booksAPI: new BooksAPI()
    })
});

//   const server = new ApolloServer({ typeDefs, resolvers });

// The `listen` method launches a web server.
server.listen().then(({ url }) => {
  console.log(`🚀  Server ready at ${url}`);
});