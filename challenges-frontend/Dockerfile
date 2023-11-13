FROM node:18

WORKDIR /challenges-frontend
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
CMD [ "npm", "start" ]
#FROM nginx:1.19
#COPY build /usr/share/nginx/html/
