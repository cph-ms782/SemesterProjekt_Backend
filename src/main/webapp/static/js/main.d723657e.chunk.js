(this.webpackJsonpreact_security=this.webpackJsonpreact_security||[]).push([[0],{22:function(e,t,a){e.exports=a(38)},27:function(e,t,a){},28:function(e,t,a){},29:function(e,t,a){},38:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),r=a(19),c=a.n(r),o=(a(27),a(28),a(29),a(6)),i=a(10),u=a(5),m=a(8),s=a.n(m),d=a(12),E="https://sandersolutions.dk/ca3_backend";function p(e,t){var a={method:e,headers:{"Content-type":"application/json"}};return t&&(a.body=JSON.stringify(t)),a}function f(e){return e.ok?e.json():Promise.reject({status:e.status,fullError:e.json()})}var v=function(){function e(){return(e=Object(d.a)(s.a.mark((function e(){var t,a;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t={method:"OPTIONS",headers:{"Access-Control-Request-Method":E,"Access-Control-Request-Headers":"Content-Length,API-Key"}},e.next=3,fetch(E,t).then(f);case 3:return a=e.sent,e.abrupt("return",a);case 5:case"end":return e.stop()}}),e)})))).apply(this,arguments)}function t(){return(t=Object(d.a)(s.a.mark((function e(t){var a,n,l,r;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(void 0!==t.id){e.next=8;break}return a=p("POST",t),e.next=4,fetch(E,a).then(f);case 4:return n=e.sent,e.abrupt("return",n);case 8:return l=p("PUT",t),e.next=11,fetch(E+"/"+t.id,l).then(f);case 11:return r=e.sent,e.abrupt("return",r);case 13:case"end":return e.stop()}}),e)})))).apply(this,arguments)}function a(){return(a=Object(d.a)(s.a.mark((function e(t){var a,n;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return a=p("DELETE"),e.next=3,fetch(E+"/"+t,a).then(f);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}}),e)})))).apply(this,arguments)}return{getData:function(){return e.apply(this,arguments)},addEditPerson:function(e){return t.apply(this,arguments)},deletePerson:function(e){return a.apply(this,arguments)}}}();var h=function(e){var t=e.teamName,a=e.crestURL;return console.log("Team"),console.log("crestURL",a),console.log("teamName",t),l.a.createElement("div",{className:"team"},t?l.a.createElement("div",null,l.a.createElement("p",null,t.teamName),l.a.createElement("img",{alt:t.teamName,src:a.crestURL,className:"thumbnail"})):l.a.createElement("div",null,l.a.createElement("p",null,"choose team")))};var g=function(){return console.log("AllAboutTeam"),l.a.createElement("div",null,l.a.createElement("p",null,"AllAboutTeam"),l.a.createElement("li",null,l.a.createElement(i.b,{to:"/userinfo"},"DATA")))},b=a(9),y=a.n(b),N=function(){console.log("FileForTesting");var e=Object(n.useState)([]),t=Object(o.a)(e,2),a=t[0],r=t[1];return Object(n.useEffect)((function(){console.log("useEffect"),console.log("cities");fetch("https://sandersolutions.dk/sem3_backend/api/fb/teams").then((function(e){return e.json()})).then((function(e){r(e)})).catch((function(e){throw e}))}),[]),l.a.createElement("div",null,l.a.createElement("p",null,"TESTING "),l.a.createElement("select",null,l.a.createElement("option",{disabled:!0,value:!0}," - select a team - "),a.map((function(e){return l.a.createElement("option",{key:y()()},e.name)}))))};var O=function(){return console.log("NoMatch"),l.a.createElement("div",{className:"news"})};var j=function(){return console.log("News"),l.a.createElement("div",{className:"news"},l.a.createElement(N,null),l.a.createElement(g,null),l.a.createElement(O,null))},w=a(13);function k(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function x(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?k(a,!0).forEach((function(t){Object(w.a)(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):k(a).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}var A=function(e){var t=e.teamName,a=e.updateTeamName,r=e.crestURL,c=e.updateCrestURL;e.facade;console.log("Search"),console.log("teamName",t);var i=Object(n.useState)([]),u=Object(o.a)(i,2),m=u[0],s=u[1];Object(n.useEffect)((function(){console.log("useEffect"),console.log("cities");fetch("https://sandersolutions.dk/sem3_backend/api/fb/teams").then((function(e){return e.json()})).then((function(e){s(e)})).catch((function(e){throw e}))}),[]);return l.a.createElement("div",null,l.a.createElement("p",null,"Searching "),l.a.createElement("select",{onChange:function(e){console.log("handleChange"),console.log("cityList",m);var n=e.target,l=e.target.id;console.log("target.value",n.value);var o=n.value.split(" - ")[1],i=m[n.value.split(" - ")[0]].crestUrl;console.log("c1",o),console.log("c2",i),a(x({},t,Object(w.a)({},l,o))),c(x({},r,Object(w.a)({},"crestURL",i)))},id:"teamName"},l.a.createElement("option",{disabled:!0,defaultValue:!0}," - select a team - "),m.map((function(e,t){return l.a.createElement("option",{key:y()()},t," - ",e.name)})),";"))};var P=function(e){var t=e.teamName;return console.log("UserInfo"),console.log("teamName",t.teamName),l.a.createElement("div",{className:"userinfo"},l.a.createElement("p",null,"You're now following ",t.teamName),l.a.createElement("table",null,l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",null,"Name"),l.a.createElement("th",null,"Age"))),l.a.createElement("tbody",null,[{name:"John",age:"122"},{name:"Birger",age:"27"},{name:"Ib",age:"22"}].map((function(e){return l.a.createElement("tr",{key:y()()},l.a.createElement("td",null,e.name),l.a.createElement("td",null,e.age))})))))};var L=function(){return console.log("Api"),l.a.createElement("div",null,l.a.createElement("h3",null,"endpoints"),l.a.createElement("p",null,l.a.createElement("strong",null,"All")," "),l.a.createElement("ul",null,l.a.createElement("li",null,"/api/info "),l.a.createElement("li",null,"/api/info/all "),l.a.createElement("li",null,"/api/login "),l.a.createElement("li",null,"/api/info/fill ")),l.a.createElement("p",null,l.a.createElement("strong",null,"City")," "),l.a.createElement("ul",null,l.a.createElement("li",null,"/api/city "),l.a.createElement("li",null,"/api/city/cities "),l.a.createElement("li",null,"/api/fb/teams ")),l.a.createElement("p",null,l.a.createElement("strong",null,"Match")," "),l.a.createElement("ul",null,l.a.createElement("li",null,"/api/match "),l.a.createElement("li",null,"/api/match/city --\x3e ie city = Liverpool ")),l.a.createElement("p",null,l.a.createElement("strong",null,"User")," "),l.a.createElement("ul",null,l.a.createElement("li",null,"/api/info/user ")),l.a.createElement("p",null,l.a.createElement("strong",null,"Admin")," "),l.a.createElement("ul",null,l.a.createElement("li",null,"/api/info/user "),l.a.createElement("li",null,"/api/info/admin ")))};function T(){return console.log("Header"),l.a.createElement("div",null,l.a.createElement("ul",{className:"header"},l.a.createElement("li",null,l.a.createElement(i.c,{exact:!0,activeClassName:"active",to:"/"},"Home")),l.a.createElement("li",null,l.a.createElement(i.c,{exact:!0,activeClassName:"active",to:"/api"},"Api"))))}var U=function(){console.log("App");var e=Object(n.useState)(""),t=Object(o.a)(e,2),a=t[0],r=t[1],c=Object(n.useState)(""),m=Object(o.a)(c,2),s=m[0],d=m[1];return console.log("teamName",a),l.a.createElement("div",null,l.a.createElement(i.a,null,l.a.createElement(u.c,null,l.a.createElement(u.a,{exact:!0,path:"/api"},l.a.createElement(L,null))),l.a.createElement("div",null,l.a.createElement("div",{className:"container"},l.a.createElement("button",{type:"button",name:"daynight",id:"daynight"},l.a.createElement("i",{className:"fa fa-sun-o","aria-hidden":"true",id:"sun"}),l.a.createElement("i",{className:"fa fa-moon-o","aria-hidden":"true",id:"moon"})),l.a.createElement("div",{id:"top-content"},l.a.createElement(A,{teamName:a,updateTeamName:function(e){console.log("index",e),r(e)},crestURL:s,updateCrestURL:function(e){console.log("index",e),d(e)},facade:v}))),l.a.createElement("div",{className:"container"},l.a.createElement("div",{id:"header"},l.a.createElement("div",{id:"logo"},"logo"),l.a.createElement("div",{id:"banner"},"banner"))),l.a.createElement("div",{className:"container"},l.a.createElement("div",{id:"menubar"},l.a.createElement(T,null))),l.a.createElement("div",{className:"container"},l.a.createElement("div",{id:"newsticker"},"newsticker")),l.a.createElement("div",{className:"container"},l.a.createElement("div",{id:"cont-1"},l.a.createElement("div",{id:"team"},l.a.createElement(h,{teamName:a,crestURL:s})),l.a.createElement("div",{id:"userinfo"},l.a.createElement(P,{teamName:a}))),l.a.createElement("div",{id:"cont-2"},l.a.createElement("div",{id:"part-1"},l.a.createElement("div",{id:"map"},"map"),l.a.createElement("div",{id:"nextmatch"},"nextmatch"),l.a.createElement("div",{id:"buy"},"buy")),l.a.createElement("div",{id:"news"},l.a.createElement(j,null))),l.a.createElement("div",{id:"cont-3"},l.a.createElement("div",{id:"leaderboard"},"leaderboard"))))))};c.a.render(l.a.createElement(U,null),document.getElementById("root"))}},[[22,1,2]]]);
//# sourceMappingURL=main.d723657e.chunk.js.map