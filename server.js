'use strict';

const Hapi = require('@hapi/hapi');
const Inert = require('@hapi/inert');
const { request } = require('http');
const path = require('path');

const init = async() => {
    const server = Hapi.Server({
        host: 'localhost',
        port: 1234,
        routes: {
            files: {
                relativeTo: path.join(__dirname, 'static')
            }
        }
    });

    await server.register([{
            plugin: require('hapi-geo-locate'),
            options: {
                enabledByDefault: true
            }
        },
        {
            plugin: Inert
        },
        {
            plugin: require('@hapi/vision')
        }
    ]);

    server.views({
        engines: {
            html: require('handlebars')
        },
        path: path.join(__dirname, 'views'),
        layout: 'default'
    })

    server.route([{
            method: 'GET',
            path: '/',
            handler: (request, h) => {
                return h.file('welcome.html');
            }
        },
        {
            method: 'GET',
            path: '/dynamic',
            handler: (request, h) => {
                const data = {
                    name: 'dansers'
                }
                return h.view('index', data);
            }
        },
        {
            method: 'POST',
            path: '/login',
            handler: (request, h) => {
                /*console.log(request.payload.username);
                console.log(request.payload.password);
                return "hi";*/
                /*if (request.payload.username === "dansers" && request.payload.password === "ninjaornun2") {
                    return h.file('logged-in.html');
                    //return "<h1>You are logged in</h1>"
                } else {
                    return h.redirect('/');
                    //return "<h1>Wrong Password</h1>"
                }*/
                return h.view('index', { username: request.payload.username });
            }
        },
        {
            method: 'GET',
            path: '/download',
            handler: (request, h) => {
                return h.file('welcome.html', {
                    mode: 'inline',
                    filename: 'welcome-download.html'
                });
            }
        },
        {
            method: 'GET',
            path: '/location',
            handler: (request, h) => {
                if (request.location) {
                    return h.view('location', { location: request.location.ip });
                } else {
                    return h.view('location', { location: 'Lokasi Anda tidak dikenal' });
                }
            }
        },
        {
            method: 'GET',
            path: '/users/{user?}',
            handler: (request, h) => {
                return "<h1>USERS PAGE</h1>";
            }
        },
        {
            method: 'GET',
            path: '/{any*}',
            handler: (request, h) => {
                return "<h1>Oh no, you must be lost!</h1>"
            }
        },
    ]);

    await server.start();
    console.log(`Server berjalan di ${server.info.uri}`);
}

process.on('unhandledRejection', (err) => {
    console.log(err);
    process.exit(1);
})

init();