declare module '@apiverve/websitetopdf' {
  export interface websitetopdfOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface websitetopdfResponse {
    status: string;
    error: string | null;
    data: WebsitetoPDFData;
    code?: number;
  }


  interface WebsitetoPDFData {
      marginLeft:   string;
      marginRight:  string;
      marginTop:    string;
      marginBottom: string;
      landscape:    boolean;
      pdfName:      string;
      expires:      number;
      url:          string;
      downloadURL:  string;
  }

  export default class websitetopdfWrapper {
    constructor(options: websitetopdfOptions);

    execute(callback: (error: any, data: websitetopdfResponse | null) => void): Promise<websitetopdfResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: websitetopdfResponse | null) => void): Promise<websitetopdfResponse>;
    execute(query?: Record<string, any>): Promise<websitetopdfResponse>;
  }
}
