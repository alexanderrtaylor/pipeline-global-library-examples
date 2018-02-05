package org.foo

def api; 
def lib;
def builds;

def dotnetapi(cfg)
{
    def build = new dotnetApiBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    //api = build
    builds[build.projectName] = build
}

def dotnetlib(cfg)
{
    Map builds_local = [:]
    def build = new dotnetlibBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    lib = build
    builds_local.put(build.projectName, build)
}

def execute()
{
    node ()
    {
       for (build in standardBuildSpec.builds)
       {
            stage (build.projectName) 
            {
                build.execute()
            }
        }
    }
}
