# Activité Pratique N°3 : Spring MVC Spring Data JPA Thymeleaf

## 1. **entité JPA `Patient`** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/a219ec98-0a66-41e4-8d89-c7c5bb14a645)<br>

## 2. **Repository `Patient`** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/700a36f2-3c35-4dde-a10b-5bb3199764c3)<br>

## 3. **Service `Patient`** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/db20f90f-44bd-42f6-88e0-b4b3a5e53fbd)<br>

## 4. **Configuration de Security** <br>
Dans cette classe, nous définissons les utilisateurs de notre application ainsi que leurs rôles. De plus, nous définissons les rôles nécessaires pour accéder à chaque page.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/23c48ca1-f067-41c3-a52e-c6bb8bef323a)<br>

## 4. **Configuration de contrôleurs** <br>
Cette partie est divisée en deux contrôleurs, l'un pour gérer tout ce qui concerne les patients et l'autre pour gérer tout ce qui concerne la sécurité.<br>
### a. **Contrôleur `Patient` ** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/4aac643c-4c35-4fa0-a701-61126a81da6c)<br>
### b. **Contrôleur `Sécurité` ** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/6abd138f-34ad-420a-a9f9-a6ebc46c40cc)<br>
## 4. **Pages Html** <br>
Cette partie est divisée en plusieurs pages, chacune dédiée à un rôle spécifique et utilisant son propre contrôleur.<br>
### a. **Page `Login` ** <br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/268acf61-5a75-4a60-8a74-bc1d29c0fdab)<br>
### b. **Page `template` ** <br>
Cette page joue le rôle d'un menu qui apparaît sur toutes les pages. Pour le bouton 'Nouveau patient', la page vérifie le rôle de l'utilisateur avant de l'afficher. Si l'utilisateur n'est pas un administrateur, le bouton ne s'affichera pas.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/c88fe5e3-87f4-48a3-99ff-b9a5d7166097)<br>
### c. **Page `patients` ** <br>
La page principale qui affiche les patients disponibles et vérifie si un utilisateur est un administrateur pour lui accorder le droit de supprimer et de modifier les patients.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/e9081951-4489-44e3-9375-72590d0c4621)<br>
### d. **Page `editPatients` ** <br>
Le formulaire pour modifier les patients n'est accessible qu'à l'administrateur, qui a l'autorité pour accéder à cette page.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/854a8ae9-c69d-4995-aa35-479118e76a4b)<br>
### e. **Page `formPatient` ** <br>
Le formulaire pour ajouter les patients n'est accessible qu'à l'administrateur, qui a l'autorité pour accéder à cette page.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/18a600cc-d3cf-4e5f-9ef9-f5717b3a9a73)<br>
### e. **Page `notAuthorized` ** <br>
Page qui apparaît à un utilisateur normal lorsqu'il essaie d'accéder à une page sans autorisation.<br>
![image](https://github.com/AnassSSG/JEE_TP3/assets/133109998/f346b80b-1b0c-406f-b67b-3e908e45595e)<br>
