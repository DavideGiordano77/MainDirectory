const swaggerJSDoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');
const path = require('path');

const options = {
    swaggerDefinition: {
        openapi: '3.0.0',
        info: {
            title: 'Movies API',
            version: '1.0.0',
            description: 'Documentazione delle API di Express',
        },
        servers: [
            {
                url: 'http://localhost:3001', // URL corretto per il server
            },
        ],
    },
    apis: [path.join(__dirname, '../routes/*.js')], // Percorso per tutte le rotte
};

const swaggerSpec = swaggerJSDoc(options);

const setupSwagger = (app) => {
    app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec)); // Documentazione API
    app.get('/swagger.json', (req, res) => {
        res.setHeader('Content-Type', 'application/json');
        res.send(swaggerSpec);
    });
};

module.exports = setupSwagger;
