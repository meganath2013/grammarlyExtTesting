(self.webpackChunk=self.webpackChunk||[]).push([[7026],{45702:(e,t,n)=>{n.r(t),n.d(t,{OnboardingPopup:()=>p});var o=n(5872),a=n(7417),r=n(88326),i=n(62111),s=n(27378),c=n(19106),l=n(61658);class p extends s.Component{constructor(){super(...arguments),this.cancel=()=>{this.props.remove()}}componentDidMount(){c.J.onboardingPopupShow(),(0,i.T)().onboardingPopupShow()}render(){return s.createElement("div",{className:(0,o.cs)(l.gButtonPopup,l.onboarding,this.props.isFlipped&&l.flipped)},s.createElement("p",{className:l.title},"Grammarly is Now Active"),s.createElement("p",{className:l.text},"Want to see how it works?"),s.createElement(a.z,{dataGrammarlyPart:"btnTakeOnboardingTour",cls:"onboarding",styles:{width:"180px"},text:"take a quick tour",onClick:()=>this.props.startOnboardingTour()}),s.createElement(r.M,{dataGrammarlyPart:"btnCancelOnboarding",clickHandler:()=>{c.J.onboardingPopupCloseButtonClick("onboardingPopup"),(0,i.T)().onboardingPopupCancel(),this.cancel()}},s.createElement("button",{className:l.link},"No, thanks")),s.createElement("div",{className:(0,o.cs)(l.popupFooter,this.props.isFlipped&&l.isFlipped)},"▲"))}}},7417:(e,t,n)=>{n.d(t,{z:()=>c});var o=n(5872),a=n(88326),r=n(27378),i=n(61007);n(54817);const s=({className:e})=>r.createElement("div",{className:`gr_-spinner ${e}`},r.createElement("div",{className:"gr_-bounce1"}),r.createElement("div",{className:"gr_-bounce2"}),r.createElement("div",{className:"gr_-bounce3"}));class c extends r.Component{constructor(){super(...arguments),this.onClick=e=>{e.preventDefault(),this.props.loading||this.props.onClick&&this.props.onClick(e)}}render(){const{loading:e,cls:t}=this.props,n=e?"":this.props.text,c=this.props.styles||{width:290},l=(0,o.cs)({[i.buttonContainer]:!0,[i[t]]:void 0!==t,[i.loading]:e});return r.createElement("div",{className:l,style:c},e&&r.createElement(s,{className:i.buttonSpinner}),r.createElement(a.M,{clickHandler:this.onClick,dataGrammarlyPart:this.props.dataGrammarlyPart},r.createElement("button",{type:"button",style:c,className:i.button},n)))}}},61658:e=>{e.exports={gButtonPopup:"_1kF5v",newDataControl:"_2DXpn",showWrapper:"jbUGk",flipped:"_33Y70",title:"_3j0IH",icon:"_3mzPB",button:"_3ayiu",buttonText:"_3iTGv",popupFooter:"_1Pn79",isFlipped:"mrPCR",settings:"_1wln3",loginSSOPopup:"_3VfKv",text:"_1igtd",bold:"_233YR",link:"_3Zolz",secondary:"_3CC0d",firstTime:"eytxh",close:"_1Q8MJ",disable:"_2GBXV",gdocs:"_1rwC7",gdocsBeta:"_3Nt7c",header:"_2QN8E",headerUnavailable:"_3oKby",cardsIcon:"_2p0cU",bubbleArrow:"_3P-V4",unavailablePopup:"_3ItKT",loginReminder:"_3nwkh",permission:"_3t67i",buttonsContainer:"_1o9Lo",mainButton:"_2Ltwz",secondaryButton:"_1gDFt",onboarding:"_36Myk",chipmunkGButtonCalloutPopup:"_1BqSc",closeWrapper:"_1iSkp",containerContents:"_3-RfQ",container:"_3DqWc",containerHeaderDefault:"tSLDM",containerKeyboardQRCodeImageBlock:"_35_s3",qrcode:"_25Ol6",containerBrandToneImageBlock:"_26_GC",img:"_38WyO",containerSnippetImageBlock:"g-PwS",containerLlamaAdoptionImageBlock:"_2rwye",containerOwnerActivationImageBlock:"AUmvb",containerGraduationImageBlock:"_2k9Eq",containerWritingProgressImageBlock:"_3kUAr",containerHeaderImageBlock:"_2u4gj",containerTitle:"_3SP28",containerText:"w2FY9",containerButton:"_3p4LT",dismiss:"_1CkBd",chipmunkGButtonToastPopup:"_4Bqy9",warningPopup:"dcXJa",btn:"_36yMW",warning:"_3IVIe",ctaBtnGroup:"_1Bbg8",ctaButton:"_1mTiW",later:"_22eWb",managedSSOControl:"nF7Y6",illustration:"ThWjl",signInWithSSO:"_3cCtR",signInWithSSO2:"_2Z9Lo"}},61007:e=>{e.exports={buttonContainer:"zh9NK",form:"_1Fp6z",buttonSpinner:"_2ox-M",button:"w4BE8",loading:"II5Au",onboarding:"_3f6zz",disable:"_26Laa"}},54817:()=>{}}]);