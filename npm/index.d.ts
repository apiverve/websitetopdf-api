declare module '@apiverve/websitetopdf' {
  export interface websitetopdfOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface websitetopdfResponse {
    status: string;
    error: string | null;
    data: WebsitetoPDFData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface WebsitetoPDFData {
      marginLeft:   null | string;
      marginRight:  null | string;
      marginTop:    null | string;
      marginBottom: null | string;
      landscape:    boolean | null;
      pdfName:      null | string;
      expires:      number | null;
      url:          null | string;
      downloadURL:  null | string;
  }

  export default class websitetopdfWrapper {
    constructor(options: websitetopdfOptions);

    execute(callback: (error: any, data: websitetopdfResponse | null) => void): Promise<websitetopdfResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: websitetopdfResponse | null) => void): Promise<websitetopdfResponse>;
    execute(query?: Record<string, any>): Promise<websitetopdfResponse>;
  }
}
