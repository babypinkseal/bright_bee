import express from "express";
import db from "./config/database.js";
import dotenv from "dotenv";
import cookieParser from "cookie-parser";
import cors from "cors";
import router from "./routes/server.js";
dotenv.config();
//import Users from "./models/usermodel.js"; //nanti pas upload di gcp buat sql disitu lalu uncomment ini
const app = express();

try {
    await db.authenticate();
    console.log('Database terhubung...');
    //await Users.sync(); //nanti pas upload di gcp buat sql disitu lalu uncomment ini

} catch (error) {
    console.error(error);

}
app.use(cors({ credentials: true, origin: 'http://localhost:3000' }));
app.use(cookieParser());
app.use(express.json());
app.use(router);

app.listen(5000, () => console.log('Server berjalan di port 5000'));